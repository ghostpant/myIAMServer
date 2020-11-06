package my.iam.dao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import my.iam.dao.table.UserDO;

/**
 * @author kingdee lwt 2020/10/4
 */
public interface UserInfoIService extends IService<UserDO> {

    UserDO getUserByEmail(String traceId, String email);

    UserDO getUserByPhone(String traceId, String email);

    UserDO userLoginCheck(String traceId, String name, String pwd);

    int registerUserByPhone(String traceId, String sysCode, String account, String userName, String password, String phone);

    int registerUserByEmail(String traceId, String sysCode, String account, String userName, String password, String email);
}
