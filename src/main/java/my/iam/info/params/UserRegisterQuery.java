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

    @NonNull
    private String registerType;

    @NonNull
    private String sysCode;
}
