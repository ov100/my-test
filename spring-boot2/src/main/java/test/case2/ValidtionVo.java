package test.case2;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * @description: 测试验证vo
 * @author: gb
 * @create: 2020/09/25
 */
@Data
public class ValidtionVo {
    @NotBlank
    @Length(min=3,max=20,message = "用户名长度在3...20")
    private String name;

    @Email(message = "邮箱格式不正确")
    @NotBlank(message = "邮箱不能为空")
    private String email;

    @Min(value=18,message = "年龄最小18")
    @Max(value = 40,message = "年龄最大40")
    private int age;
}
