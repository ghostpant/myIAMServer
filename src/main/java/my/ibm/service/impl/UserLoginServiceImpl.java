package my.ibm.service.impl;

import com.alibaba.fastjson.JSON;
import my.ibm.builder.ApiResultBuilder;
import my.ibm.dao.impl.UserInfoDaoImpl;
import my.ibm.dao.table.UserDO;
import my.ibm.info.params.UserLoginQuery;
import my.ibm.info.result.UserLoginVO;
import my.ibm.service.UserLoginService;
import my.ibm.utils.ApiResult;
import my.ibm.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    private static final Logger log = LoggerFactory.getLogger(UserLoginServiceImpl.class);
    private final UserInfoDaoImpl userInfoDaoImpl;
    private final RedisUtil redisUtil;

    @Autowired
    public UserLoginServiceImpl(UserInfoDaoImpl userInfoDaoImpl, RedisUtil redisUtil) {
        this.userInfoDaoImpl = userInfoDaoImpl;
        this.redisUtil = redisUtil;
    }

    /**
     * 用户登陆验证
     * TODO 手机号登陆
     * TODO 手机号格式验证
     * @param traceId 轨迹id
     * @param params 请求参数
     * @return 返回结果
     */
    @Override
    public ApiResult userLogin(String traceId, UserLoginQuery params) {
        String userName = params.getUserName();
        String password = params.getPassWord();

        //登陆校验
        UserDO userInfo = userInfoDaoImpl.userLoginCheck(traceId,userName, password);
        if (userInfo == null) {
            log.info("【用户登陆校验】 登陆失败! 用户名或密码错误, traceId = {} ", traceId);
            return ApiResultBuilder.fail(traceId, "登陆失败！用户名或密码错误", ApiResult.INFO_NOT_FOUND);
        }
        String userAccount = userInfo.getUserAccount();

        String casTicket = getCasTicket(userAccount);
        //存入redis缓存
        redisUtil.set(userAccount, casTicket, 9000);
        UserLoginVO userLoginVO = UserLoginVO.builder()
                .userAccount(userAccount)
                .userName(userName)
                .casTicket(casTicket).build();
        return ApiResultBuilder.success(traceId, "登陆成功", JSON.toJSON(userLoginVO)).build();

    }

    /**
     * 登陆成功之后，获取临时票据
     *
     * @param userAccount 用户账号
     * @return 票据信息
     */
    private String getCasTicket(String userAccount) {
        return "IAM_" + userAccount + "_" + UUID.randomUUID();
    }
}
