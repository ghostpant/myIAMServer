package my.ibm.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import my.ibm.constant.UserDOConstant;
import my.ibm.dao.mapper.UserDOMapper;
import my.ibm.dao.service.UserInfoIService;
import my.ibm.dao.table.UserDO;
import org.springframework.stereotype.Service;

@Service
public class UserInfoIServiceImpl extends ServiceImpl<UserDOMapper, UserDO> implements UserInfoIService {

    @Override
    public UserDO userLoginCheck(String traceId, String name, String pwd) {
        return baseMapper.selectOne(new QueryWrapper<UserDO>()
                .eq(UserDOConstant.USER_NAME, name)
                .eq(UserDOConstant.USER_PASSWORD, pwd)
                .eq(UserDOConstant.USER_IS_DELETE, UserDOConstant.USER_IS_NOT_DELETE));
    }

    @Override
    public int registerUserByPhone(String traceId, String sysCode, String account, String userName, String password, String phone) {

        return 0;
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
