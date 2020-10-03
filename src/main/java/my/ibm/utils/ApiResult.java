package my.ibm.utils;


public class ApiResult {

    //参数校验错误
    public static final String PARAMS_CHECK_ERROR = "10001";

    //查询数据不存在
    public static final String INFO_NOT_FOUND = "10002";

    //连接超时
    public static final String LINKING_TIME_OUT = "10003";

    //权限错误
    public static final String DO_NOT_HAS_PERMISSION = "10004";

    //接口异常
    public static final String DEFAULT_ERROR = "19000";

    //成功
    public static final String DEFAULT_SUCCESS = "200";


    private String traceId;

    private String msg;

    private String errorCode;

    private Object data;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ApiResult(String traceId, String msg) {
        this.traceId = traceId;
        this.msg = msg;
    }

    public ApiResult(String traceId, String msg, String errorCode) {
        this.traceId = traceId;
        this.msg = msg;
        this.errorCode = errorCode;
    }

    public ApiResult(String traceId, String msg, String errorCode, Object data) {
        this.traceId = traceId;
        this.msg = msg;
        this.errorCode = errorCode;
        this.data = data;
    }
}
