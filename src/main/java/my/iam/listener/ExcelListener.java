package my.iam.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import my.iam.info.execlParams.TableHeaderExcelProperty;
import my.iam.info.params.CreateEnterpriseParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ExcelListener extends AnalysisEventListener<TableHeaderExcelProperty> {

    private static int lowCount = 0;
    private static final Logger log = LoggerFactory.getLogger(ExcelListener.class);
    private List<TableHeaderExcelProperty> list = new ArrayList();
    @Override
    public void invoke(TableHeaderExcelProperty tableHeaderExcelProperty, AnalysisContext analysisContext) {
        lowCount++;
        log.info("【逐行读取Excel数据】low = {},data = {}",lowCount,tableHeaderExcelProperty);
        CreateEnterpriseParams taget = getUcEntInfo(tableHeaderExcelProperty);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    private CreateEnterpriseParams getUcEntInfo(TableHeaderExcelProperty source){
        CreateEnterpriseParams ucEntInfo = CreateEnterpriseParams.builder()
                .name(source.getEntName())
                .contactAddress(source.getDetailAddress())
                .contactName(source.getContactName())
                .isFromCreateVt("0")
                .locationId("11111")
                .manageIndustryId("11111")
                .userId("123123")
                .vtenant("hnjd")
                // "api = true"
                .ticket("")
                .build();
        return ucEntInfo;
    }
 }
