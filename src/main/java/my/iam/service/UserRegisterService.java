package my.iam.service;

import my.iam.info.params.UserRegisterQuery;
import my.iam.utils.ApiResult;

/**
 * @author kingdee lwt 2020/10/4
 */
public interface UserRegisterService {

    ApiResult userRegisterByPhone(String traceId, UserRegisterQuery params);

    ApiResult userRegisterByEmail(String traceId, UserRegisterQuery params);
}
