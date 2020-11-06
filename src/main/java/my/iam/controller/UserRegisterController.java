package my.iam.controller;


import com.alibaba.fastjson.JSON;
import my.iam.info.params.UserRegisterQuery;
import my.iam.service.impl.UserRegisterServiceImpl;
import my.iam.utils.ApiResult;
import my.iam.utils.TraceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class UserRegisterController {

    private static final Logger log = LoggerFactory.getLogger(UserRegisterController.class);
    private static final String REGISTER_TYPE_PHONE = "0";
    private static final String REGISTER_TYPE_EMAIL = "1";
    private final UserRegisterServiceImpl userRegisterService;

    @Autowired
    public UserRegisterController(UserRegisterServiceImpl userRegisterService) {
        this.userRegisterService = userRegisterService;
    }

    /**
     * 用户注册
     */
    public ApiResult UserRegister(HttpServletRequest request, UserRegisterQuery params) {
        String tag = "用户注册";
        String traceId = TraceUtil.getTraceId(request);
        String type = params.getRegisterType();
        ApiResult apiResult = null;
        switch (type) {
            case REGISTER_TYPE_PHONE:
                log.info("【手机{}】请求参数：traceId = {}, params = {}", tag, traceId, JSON.toJSON(params));
                apiResult = userRegisterService.userRegisterByPhone(traceId, params);
            case REGISTER_TYPE_EMAIL:
                log.info("【邮箱{}】请求参数：traceId = {}, params = {}", tag, traceId, JSON.toJSON(params));
                apiResult = userRegisterService.userRegisterByEmail(traceId, params);
        }
        log.info("【{}】请求结果：traceId = {}, params = {}", tag, traceId, JSON.toJSON(params));
        return apiResult;
    }
}
