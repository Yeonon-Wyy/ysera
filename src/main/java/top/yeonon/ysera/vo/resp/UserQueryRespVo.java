package top.yeonon.ysera.vo.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: yeonon
 * @date: 2019/12/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQueryRespVo {

    private String phoneNumber;
    private String nickName;
    private Integer gender;
    private Date createTime;
    private Date updateTime;
}
