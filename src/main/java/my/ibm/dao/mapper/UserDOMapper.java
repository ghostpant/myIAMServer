package my.ibm.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import my.ibm.dao.table.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author kingdee lwt 2020/10/4
 */
@Mapper
public interface UserDOMapper extends BaseMapper<UserDO> {
}
