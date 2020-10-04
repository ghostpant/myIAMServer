package my.ibm.dao.table;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("sys")
public class SysDO {

    @TableId(value = "sysid",type = IdType.AUTO)
    private long sysid;

    @TableField(value = "sysName")
    private String sysName;

    @TableField(value = "sysCode")
    private String sysCode;

    @TableField(value = "sysUrl")
    private String sysUrl;

    @TableField(value = "isdelete")
    private int isdelete;
}
