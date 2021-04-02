package my.iam.info.execlParams;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * EXECL 表格 列参数
 */
@EqualsAndHashCode()
@Data
public class TableHeaderExcelProperty {

    @ExcelProperty(value = "企业名称", index = 0)
    private String entName;

    @ExcelProperty(value = "联系人", index = 1)
    private String contactName;

    @ExcelProperty(value = "联系电话", index = 2)
    private String contactPhone;

    @ExcelProperty(value = "省市区", index = 3)
    private String locationId;

    @ExcelProperty(value = "详细地址", index = 4)
    private String detailAddress;

    @ExcelProperty(value = "用户ID", index = 5)
    private String userId ;
}
