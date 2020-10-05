package my.ibm.dao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import my.ibm.dao.table.SysDO;

/**
 * @author kingdee lwt 2020/10/4
 */
public interface SysDOIService extends IService<SysDO> {

    SysDO getSysDOByCode(String traceId, String sysCode);
}
