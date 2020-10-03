package my.ibm.service;

import my.ibm.info.params.UserLoginQuery;
import my.ibm.utils.ApiResult;

public interface UserLoginService {

    ApiResult userLogin(String traceId, UserLoginQuery params);
}
