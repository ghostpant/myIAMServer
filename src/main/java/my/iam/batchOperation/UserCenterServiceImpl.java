package my.iam.batchOperation;

import com.alibaba.fastjson.JSON;
import my.iam.info.execlParams.TableHeaderExcelProperty;
import my.iam.utils.ExcelUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCenterServiceImpl implements UserCenterService {



    public boolean readExecl(TableHeaderExcelProperty params){
        String execlPath = "C:\\Users\\kingdee\\Desktop\\批量测试.xlsx";
        List<Object> objects = ExcelUtil.readLessThan1000Row(execlPath);
        System.out.println(JSON.toJSONString(objects));
        return false;
    }
}

