package my.iam.service.impl;

import my.iam.service.SynDataTaskService;
import my.iam.utils.ApiResult;
import org.springframework.stereotype.Service;

@Service
public class SynDataTaskServiceImpl implements SynDataTaskService {




    /**
     * TODO 获取用户通用统一对外标识 userAccount,
     * TODO 构建传输对象, 推给AsynServer，
     * TODO 是否需要统一字段对应关系，
     */


    @Override
    public ApiResult push(String traceId, String userId) {
        return null;
    }

    @Override
    public ApiResult pull(String traceId, String userId) {
        return null;
    }
}
