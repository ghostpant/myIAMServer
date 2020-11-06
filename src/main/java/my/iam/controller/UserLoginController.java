package my.iam.controller;

import com.alibaba.fastjson.JSON;
import my.iam.info.params.UserLoginQuery;
import my.iam.service.impl.UserLoginServiceImpl;
import my.iam.utils.ApiResult;
import my.iam.utils.TraceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author li_weitao
 * 2020/8/5
 */
@RestController
public class UserLoginController {

    private static final Logger log = LoggerFactory.getLogger(UserLoginController.class);
    private final UserLoginServiceImpl userLoginService;

    public UserLoginController(UserLoginServiceImpl userLoginService) {
        this.userLoginService = userLoginService;
    }


    /**
     * 用户登陆
     *
     * @param request 请求体
     * @param params  请求参数
     * @return 返回结果
     */
    @RequestMapping(value = "/rest/user/login", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult userLogin(HttpServletRequest request,  @Valid @RequestBody UserLoginQuery params) {
        String traceId = TraceUtil.getTraceId(request);
        log.info("【用户登陆】 traceId = {}, 请求参数 params = {}", traceId, JSON.toJSON(params));
        ApiResult apiResult = userLoginService.userLogin(traceId, params);
        return apiResult;
    }

    //TODO 单点登录
}
