package my.iam.info.params;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class WxQRcodeParams {


    @NotNull(message = "scene不能为空")
    private String scene;
}
