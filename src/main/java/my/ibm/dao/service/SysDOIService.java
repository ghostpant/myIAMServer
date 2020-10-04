package my.ibm.dao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import my.ibm.dao.table.SysDO;

public interface SysDOIService extends IService<SysDO> {

    SysDO getSysDOByCode(String traceId, String sysCode);
}
