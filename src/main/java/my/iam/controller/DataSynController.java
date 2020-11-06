package my.iam.controller;

import com.alibaba.fastjson.JSON;
import my.iam.service.impl.SynDataTaskServiceImpl;
import my.iam.utils.ApiResult;
import my.iam.utils.TraceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DataSynController {

    private static final Logger logger = LoggerFactory.getLogger(DataSynController.class);

    private final SynDataTaskServiceImpl synDataTaskService;

    @Autowired
    public DataSynController(SynDataTaskServiceImpl synDataTaskService) {
        this.synDataTaskService = synDataTaskService;
    }

    @RequestMapping(value = "/rest/pushData",method = RequestMethod.POST)
    public ApiResult pushData(HttpServletRequest request,@RequestBody String userId){
        String tag = "推送数据";
        String traceId = TraceUtil.getTraceId(request);
        logger.info("【{}】请求参数， traceId = {}, userId = {}",tag,traceId,userId);
        ApiResult result = synDataTaskService.push(traceId,userId);
        logger.info("【{}】请求结果， traceId = {}, result = {}",tag,traceId, JSON.toJSONString(result));
        return result;
    }
}
