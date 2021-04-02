package my.iam.service.impl;

import my.iam.builder.ApiResultBuilder;
import my.iam.dao.impl.UserInfoIServiceImpl;
import my.iam.dao.table.UserDO;
import my.iam.info.params.UserRegisterQuery;
import my.iam.service.UserRegisterService;
import my.iam.utils.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liweitao 2020/9/27
 * 用户注册
 */
@Service
public class UserRegisterServiceImpl implements UserRegisterService {

    private static final Logger log = LoggerFactory.getLogger(UserRegisterServiceImpl.class);
    private final UserInfoIServiceImpl userInfoIService;

    @Autowired
    public UserRegisterServiceImpl(UserInfoIServiceImpl userInfoIService) {
        this.userInfoIService = userInfoIService;
    }

    @Override
    public ApiResult userRegisterByPhone(String traceId, UserRegisterQuery params) {
        String tag = "通过手机号注册用户";
        String userPhone = params.getPhone();
        boolean phoneValid = vaildUserPhone(traceId, tag, userPhone);
        if (!phoneValid) {
            return ApiResultBuilder.fail(traceId, "注册失败，手机号不合法", ApiResult.PARAMS_CHECK_ERROR, userPhone).build();
        }
        String userAccount = getUserAccount(traceId, tag);
        String userName = params.getUserName();
        String password = params.getPassword();
        String sysCode = params.getSysCode();

        int updateCount = userInfoIService.registerUserByPhone(traceId, sysCode, userAccount, userName, password, userPhone);
        if (updateCount > 0) {
            return ApiResultBuilder.success("【{}】注册成功, traceId = {},userphone = {}", tag, traceId, userPhone).build();
        }
        return ApiResultBuilder.fail("【{}】注册失败, traceId = {},userphone = {}", tag, traceId, userPhone).build();
    }

    @Override
    public ApiResult userRegisterByEmail(String traceId, UserRegisterQuery params) {
        String tag = "通过邮箱注册用户";
        String email = params.getEmail();
        boolean emailVaild = validUserEmail(traceId, tag, email);
        if (!emailVaild) {
            return ApiResultBuilder.fail(traceId, "注册失败，邮箱不合法", ApiResult.PARAMS_CHECK_ERROR, email).build();
        }
        String userAccount = getUserAccount(traceId, tag);
        String userName = params.getUserName();
        String password = params.getPassword();
        String sysCode = params.getSysCode();
        int updateCount = userInfoIService.registerUserByEmail(traceId, sysCode, userAccount, userName, password, email);
        if (updateCount > 0) {
            return ApiResultBuilder.success("【{}】注册成功, traceId = {},userphone = {}", tag, traceId, email).build();
        }
        return ApiResultBuilder.fail("【{}】注册失败, traceId = {},userphone = {}", tag, traceId, email).build();
    }

    /**
     * 验证手机号是否合法
     *
     * @param traceId 轨迹id
     * @param tag     通过手机号注册用户
     * @param phone   手机号
     * @return 验证结果
     */
    private boolean vaildUserPhone(String traceId, String tag, String phone) {
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phone);
        if (!m.matches()) {
            log.info("【{}】失败, 手机号格式错误！traceId = {}, phone = {}", tag, traceId, phone);
            return false;
        }
        UserDO userDO = userInfoIService.getUserByPhone(traceId, phone);
        if (userDO != null) {
            log.info("【{}】失败, 手机号已被注册！traceId = {}, phone = {}", tag, traceId, phone);
            return false;
        }
        return true;
    }

    /**
     * 验证邮箱是否合法
     *
     * @param traceId 轨迹id
     * @param tag     通过邮箱注册用户
     * @param email   邮箱
     * @return 验证结果
     */
    private boolean validUserEmail(String traceId, String tag, String email) {
        String regex = "^([a-z0-9A-Z]+[-|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            log.info("【{}】失败, 邮箱格式错误！traceId = {}, phone = {}", tag, traceId, email);
            return false;
        }
        UserDO userDO = userInfoIService.getUserByEmail(traceId, email);
        if (userDO != null) {
            log.info("【{}】失败, 手机号已被注册！traceId = {}, phone = {}", tag, traceId, email);
            return false;
        }
        return true;
    }

    private String getUserAccount(String traceId, String tag) {
        log.info("【{}生成account】traceId = {}", tag, traceId);
        return "FU" + UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }
}
