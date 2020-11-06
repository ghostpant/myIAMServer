package my.iam.service;

import my.iam.utils.ApiResult;

public interface SynDataTaskService {

    ApiResult push(String traceId, String userId);

    ApiResult pull(String traceId, String userId);
}
