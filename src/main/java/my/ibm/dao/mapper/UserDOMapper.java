package my.ibm.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import my.ibm.dao.table.UserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDOMapper extends BaseMapper<UserDO> {
}
