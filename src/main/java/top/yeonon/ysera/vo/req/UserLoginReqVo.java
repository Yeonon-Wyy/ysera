package top.yeonon.ysera.vo.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author: yeonon
 * @date: 2019/12/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginReqVo {

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String password;
}
