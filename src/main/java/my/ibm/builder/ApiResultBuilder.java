package my.ibm.builder;

import my.ibm.utils.ApiResult;

public class ApiResultBuilder {

    ApiResult apiResult;

    String traceId;
    String msg;
    String errorCode;
    Object data;

    public ApiResultBuilder( String traceId, String msg, String errorCode, Object data) {
        this.traceId = traceId;
        this.msg = msg;
        this.errorCode = errorCode;
        this.data = data;
    }

    public ApiResultBuilder(String traceId, String msg, String errorCode) {
        this.traceId = traceId;
        this.msg = msg;
        this.errorCode = errorCode;
    }

    public  ApiResult build(){
        return apiResult = new ApiResult(traceId, msg,errorCode, data);
    }

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

    public static ApiResultBuilder fail(String traceId, String msg, String errorCode, Object data) {
        return new ApiResultBuilder(traceId, msg, errorCode, data);
    }

    public static ApiResultBuilder fail(String traceId, String msg, Object data) {
        return new ApiResultBuilder(traceId, msg, ApiResult.DEFAULT_ERROR, data);
    }

    public static ApiResult fail(String traceId, String msg, String errorCode) {
        return new ApiResult(traceId, msg, errorCode);
    }

    public static ApiResult fail(String traceId, String msg) {
        return new ApiResult(traceId, msg, ApiResult.DEFAULT_ERROR);
    }
}
