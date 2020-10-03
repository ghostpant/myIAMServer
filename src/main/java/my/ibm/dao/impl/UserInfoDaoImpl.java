package my.ibm.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import my.ibm.constant.UserInfoConstant;
import my.ibm.dao.mapper.UserInfoMapper;
import my.ibm.dao.table.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoDaoImpl {

    private  final UserInfoMapper userInfoMapper;

    @Autowired
    public UserInfoDaoImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    public UserDO userLoginCheck(String traceId,String name, String pwd) {
        return userInfoMapper.selectOne(new QueryWrapper<UserDO>()
                .eq(UserInfoConstant.USER_NAME,name)
                .eq(UserInfoConstant.USER_PASSWORD,pwd)
                .eq(UserInfoConstant.USER_IS_DELETE,UserInfoConstant.IS_NOT_DELETE));
    }

    public UserDO getUserByPhone(String traceId, String phone){
        return userInfoMapper.selectOne(new QueryWrapper<UserDO>()
        .eq(UserInfoConstant.USER_PHONE,phone)
        .eq(UserInfoConstant.USER_IS_DELETE,UserInfoConstant.IS_NOT_DELETE));
    }

}
