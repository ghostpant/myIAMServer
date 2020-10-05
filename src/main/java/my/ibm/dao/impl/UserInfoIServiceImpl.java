package my.ibm.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import my.ibm.constant.UserDOConstant;
import my.ibm.dao.mapper.UserDOMapper;
import my.ibm.dao.service.UserInfoIService;
import my.ibm.dao.table.SysDO;
import my.ibm.dao.table.UserDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kingdee lwt 2020/10/4
 */
@Service
public class UserInfoIServiceImpl extends ServiceImpl<UserDOMapper, UserDO> implements UserInfoIService {

    private static final Logger log = LoggerFactory.getLogger(UserInfoIServiceImpl.class);
    private final SysDOIServiceImpl sysDOIService;

    @Autowired
    public UserInfoIServiceImpl(SysDOIServiceImpl sysDOIService) {
        this.sysDOIService = sysDOIService;
    }

    @Override
    public UserDO userLoginCheck(String traceId, String name, String pwd) {
        return baseMapper.selectOne(new QueryWrapper<UserDO>()
                .eq(UserDOConstant.USER_NAME, name)
                .eq(UserDOConstant.USER_PASSWORD, pwd)
                .eq(UserDOConstant.USER_IS_DELETE, UserDOConstant.USER_IS_NOT_DELETE));
    }

    @Override
    public int registerUserByPhone(String traceId, String sysCode, String account, String userName, String password, String phone) {
        int updateCount = 0;
        SysDO sys = sysDOIService.getSysDOByCode(traceId, sysCode);
        if (sys == null) {
            log.info("【手机注册用户】失败, 该用户没有加入对应的系统 traceId = {}, sysCode = {}", traceId, sysCode);
            return 0;
        }
        UserDO user = UserDO.builder()
                .userAccount(account)
                .userFlag(0)
                .userName(userName)
                .passWord(password)
                .userPhone(phone)
                .isdelete(0)
                .sysid(sys.getSysid()).build();
        updateCount = baseMapper.insert(user);
        return updateCount;
    }
    @Override
    public int registerUserByEmail(String traceId, String sysCode, String account, String userName, String password, String email) {
        int updateCount = 0;
        SysDO sys = sysDOIService.getSysDOByCode(traceId, sysCode);
        if (sys == null) {
            log.info("【邮箱注册用户】失败, 该用户没有加入对应的系统 traceId = {}, sysCode = {}", traceId, sysCode);
            return 0;
        }
        UserDO user = UserDO.builder()
                .userAccount(account)
                .userFlag(0)
                .userName(userName)
                .passWord(password)
                .email(email)
                .isdelete(0)
                .sysid(sys.getSysid()).build();
        updateCount = baseMapper.insert(user);
        return updateCount;
    }

    @Override
    public UserDO getUserByPhone(String traceId, String phone) {
        return baseMapper.selectOne(new QueryWrapper<UserDO>()
                .eq(UserDOConstant.USER_PHONE, phone)
                .eq(UserDOConstant.USER_IS_DELETE, UserDOConstant.USER_IS_NOT_DELETE));
    }

    @Override
    public UserDO getUserByEmail(String traceId, String email) {
        return baseMapper.selectOne(new QueryWrapper<UserDO>()
                .eq(UserDOConstant.USER_EMAIL, email)
                .eq(UserDOConstant.USER_IS_DELETE, UserDOConstant.USER_IS_NOT_DELETE));
    }

}
