package my.iam.info.params;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Builder
public class CreateEnterpriseParams implements Serializable {
    private String ticket;

    private String userId;

    @NotEmpty(message = "门户信息不能为空")
    private String vtenant;

    @NotEmpty(message = "企业详细地址不能为空")
    private String contactAddress;

    @NotEmpty(message = "联系人姓名不能为空")
    private String contactName;

    @NotEmpty(message = "企业地址不能为空")
    private String locationId;

    @NotEmpty(message = "企业所属行业不能为空")
    private String manageIndustryId;

    @NotEmpty(message = "企业名称不能为空")
    private String name;

    @NotEmpty(message = "是否虚拟租户创建参数不能为空")
    private String isFromCreateVt;
}
