package my.ibm.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import my.ibm.constant.SysDOConstant;
import my.ibm.dao.mapper.SysDOMapper;
import my.ibm.dao.service.SysDOIService;
import my.ibm.dao.table.SysDO;
import org.springframework.stereotype.Service;

/**
 * @author kingdee lwt 2020/10/4
 */
@Service
public class SysDOIServiceImpl extends ServiceImpl<SysDOMapper, SysDO> implements SysDOIService {



    @Override
    public SysDO getSysDOByCode(String traceId, String sysCode) {
        return baseMapper.selectOne(new QueryWrapper<SysDO>()
                .eq(SysDOConstant.SYS_CODE,sysCode)
                .eq(SysDOConstant.SYS_IS_DELETE,SysDOConstant.SYS_IS_NOT_DELETE));
    }
}
