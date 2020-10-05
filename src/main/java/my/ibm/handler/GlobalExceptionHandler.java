package my.ibm.handler;

import my.ibm.builder.ApiResultBuilder;
import my.ibm.utils.ApiResult;
import my.ibm.utils.TraceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;


/**
 * @author kingdee lwt 2020/10/5
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     *  全局异常处理
     *
     * @param request 请求体
     * @param e 异常对象
     * @return 返回结果
     */
    @ExceptionHandler(value = Exception.class)
    public ApiResult exceptionHandler(HttpServletRequest request, Exception e) {
        String tag = "IAM服务";
        String traceId = TraceUtil.getTraceId(request);
        log.error("【{}】出现异常，traceId = {}, msg = {}, error = {}", traceId, e.getMessage(), e);
        return ApiResultBuilder.fail(traceId, "接口调用失败", ApiResult.DEFAULT_ERROR).build();
    }
}
