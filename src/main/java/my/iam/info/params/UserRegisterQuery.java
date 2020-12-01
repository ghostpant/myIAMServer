package my.iam.info.params;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserRegisterQuery {

    private String userName;

    @NonNull
    private String password;

    private String phone;

    private String email;

    /**
     * 0 = 手机
     * 1 = 邮箱
     */
    @NonNull
    private String registerType;

    @NonNull
    private String sysCode;
}
