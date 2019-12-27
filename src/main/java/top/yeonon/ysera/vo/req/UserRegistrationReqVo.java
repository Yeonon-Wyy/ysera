package top.yeonon.ysera.vo.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 * @author: yeonon
 * @date: 2019/12/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationReqVo {

    @NotBlank(message = "phone number can't empty")
    private String phoneNumber;

    @NotBlank(message = "password can't empty")
    private String password;

    @NotBlank(message = "nickname can't empty")
    private String nickName;

    @NotNull(message = "gender can't null")
    @PositiveOrZero(message = "gender must greater or equal zero")
    private Integer gender;
}
