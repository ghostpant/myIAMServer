package my.iam.service;

import my.iam.info.params.UserLoginQuery;
import my.iam.utils.ApiResult;

/**
 * @author kingdee lwt 2020/10/4
 */
public interface UserLoginService {

    ApiResult userLogin(String traceId, UserLoginQuery params);
}
