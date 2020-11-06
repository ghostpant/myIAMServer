package my.iam.dao.table;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("USER")
public class UserDO {

    @TableId(value = "user_id", type = IdType.AUTO)
    private long id;

    //所属系统id
    @TableField(value = "sysid")
    private long sysid;

    // 0 为冻结状态 , 1 为正常状态
    @TableField(value = "user_flag")
    private int userFlag;

    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "user_password")
    private String passWord;

    @TableField(value = "user_account")
    private String userAccount;

    @TableField(value = "is_delete")
    private int isdelete;

    @TableField(value = "user_email")
    private String email;

    @TableField(value = "user_phone")
    private String userPhone;
}
