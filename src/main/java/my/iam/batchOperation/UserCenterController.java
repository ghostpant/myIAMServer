package my.iam.batchOperation;

import com.alibaba.excel.EasyExcel;
import my.iam.info.execlParams.TableHeaderExcelProperty;
import my.iam.info.params.CreateEnterpriseParams;
import my.iam.utils.ApiResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserCenterController {


    public ApiResult batchEnterprise(HttpServletRequest request, TableHeaderExcelProperty params) {


        return null;
    }


    @RequestMapping(value = "/readToEntity",method = RequestMethod.POST)
    public Map<String, Object> toEntity(@RequestParam(value = "execlFile") MultipartFile excelFile) throws IOException {
        Map<String, Object> result = new HashMap<>();
        List<Object> list = EasyExcel.read(excelFile.getInputStream(), TableHeaderExcelProperty.class, null).sheet(0).doReadSync();
        result.put("list", list);
        return result;
    }
}
