package my.iam.aop;


import com.alibaba.fastjson.JSON;
import my.iam.customAnnotations.PrintParam;
import my.iam.utils.TraceUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    @Pointcut("@annotation(my.iam.customAnnotations.PrintParam)")
    public void printParams(){};

    @Around("printParams()")
    public Object doAround(ProceedingJoinPoint joinPoint, PrintParam printParam) throws Throwable{
        Object[] args = joinPoint.getArgs();
        String tag = printParam.tag();
        String traceId = TraceUtil.getTraceId(null);
        logger.info("【{}】请求参数：trace = {}，params = {}",tag,traceId, JSON.toJSON(args));
        Object proceed = joinPoint.proceed();
        logger.info("【{}】请求结果：trace = {}，result = {}",tag,traceId,JSON.toJSON(proceed));
        return proceed;
    }

}
