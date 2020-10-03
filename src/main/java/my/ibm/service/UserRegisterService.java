package my.ibm.service;

import my.ibm.info.params.UserRegisterQuery;
import my.ibm.utils.ApiResult;

public interface UserRegisterService {

    ApiResult userRegisterByPhone(String traceId, UserRegisterQuery params);

    ApiResult userRegisterByEmail(String traceId, UserRegisterQuery params);
}
