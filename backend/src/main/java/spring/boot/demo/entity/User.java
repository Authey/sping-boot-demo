package spring.boot.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author Authey
 * @since 2025-04-01
 */
@Getter
@Setter
@TableName("user")
@Schema(name = "User", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "用户ID")
    @TableId("USER_ID")
    private String userId;

    @Schema(description = "用户名")
    @TableField("USERNAME")
    private String username;

    @Schema(description = "密码(HASH加密存储)")
    @TableField("PASSWORD")
    private String password;

    @Schema(description = "创建时间")
    @TableField("CREATE_TIME")
    private Date createTime;
}
