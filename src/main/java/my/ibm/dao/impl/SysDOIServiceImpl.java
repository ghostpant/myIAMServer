package my.ibm.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import my.ibm.constant.SysDOConstant;
import my.ibm.dao.mapper.SysDOMapper;
import my.ibm.dao.service.SysDOIService;
import my.ibm.dao.table.SysDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysDOIServiceImpl extends ServiceImpl<SysDOMapper, SysDO> implements SysDOIService {



    @Override
    public SysDO getSysDOByCode(String traceId, String sysCode) {
        return baseMapper.selectOne(new QueryWrapper<SysDO>()
                .eq(SysDOConstant.SYS_CODE,sysCode)
                .eq(SysDOConstant.SYS_IS_DELETE,SysDOConstant.SYS_IS_NOT_DELETE));
    }
}
