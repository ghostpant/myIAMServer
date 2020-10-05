package my.ibm.service;

import my.ibm.info.params.UserLoginQuery;
import my.ibm.utils.ApiResult;

/**
 * @author kingdee lwt 2020/10/4
 */
public interface UserLoginService {

    ApiResult userLogin(String traceId, UserLoginQuery params);
}
