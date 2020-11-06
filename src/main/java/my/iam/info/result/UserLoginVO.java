package my.iam.info.result;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserLoginVO {

    private String userName;

    private String userAccount;

    private String casTicket;
}
