package top.yeonon.ysera.vo.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 * @author: yeonon
 * @date: 2019/12/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQueryReqVo {

    @NotNull(message = "id can't null")
    @PositiveOrZero(message = "id must greater or equals zero")
    private Long id;
}
