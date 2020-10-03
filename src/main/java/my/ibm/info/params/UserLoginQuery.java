package my.ibm.info.params;

import lombok.Data;
import lombok.NonNull;

@Data
public class UserLoginQuery {

    @NonNull
    private String userName;

    @NonNull
    private String passWord;


}
