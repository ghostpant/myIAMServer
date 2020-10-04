package my.ibm.builder;

import my.ibm.utils.ApiResult;

public class ApiResultBuilder {

    private ApiResult apiResult;

//    private String traceId;
//    private String msg;
//    private String errorCode;
//    private Object data;

    public ApiResultBuilder( String traceId, String msg, String errorCode, Object data) {
        apiResult = new ApiResult();
        apiResult.setData(data);
        apiResult.setErrorCode(errorCode);
        apiResult.setTraceId(traceId);
        apiResult.setMsg(msg);
    }

    public ApiResultBuilder(String traceId, String msg, String errorCode) {
        apiResult = new ApiResult();
        apiResult.setErrorCode(errorCode);
        apiResult.setTraceId(traceId);
        apiResult.setMsg(msg);
    }

    public  ApiResult build(){
        return this.apiResult;
    }

    /**
     * 返回成功
     */
    public static ApiResultBuilder success(String traceId, String msg, String errorCode, Object data) {
        return new ApiResultBuilder(traceId, msg, ApiResult.DEFAULT_SUCCESS, data);
    }

    public static ApiResultBuilder success(String traceId, String msg, Object data) {
        return new ApiResultBuilder(traceId, msg, ApiResult.DEFAULT_SUCCESS, data);
    }

    public static ApiResultBuilder success(String traceId, String msg, String errorCode) {
        return new ApiResultBuilder(traceId, msg, ApiResult.DEFAULT_SUCCESS);
    }

    public static ApiResultBuilder success(String traceId, String msg) {
        return new ApiResultBuilder(traceId, msg, ApiResult.DEFAULT_SUCCESS);
    }

    /**
     * 返回失败
     */
    public static ApiResultBuilder fail(String traceId, String msg, String errorCode, Object data) {
        return new ApiResultBuilder(traceId, msg, errorCode, data);
    }

    public static ApiResultBuilder fail(String traceId, String msg, Object data) {
        return new ApiResultBuilder(traceId, msg, ApiResult.DEFAULT_ERROR, data);
    }

    public static ApiResultBuilder fail(String traceId, String msg, String errorCode) {
        return new ApiResultBuilder(traceId, msg, errorCode);
    }

    public static ApiResultBuilder fail(String traceId, String msg) {
        return new ApiResultBuilder(traceId, msg, ApiResult.DEFAULT_ERROR);
    }
}
