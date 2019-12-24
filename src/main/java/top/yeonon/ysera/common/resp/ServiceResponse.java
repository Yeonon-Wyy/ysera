package top.yeonon.ysera.common.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yeonon
 * @date: 2019/12/24
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResponse<T> {

    private Integer code;
    private String message;
    private T data;


}
