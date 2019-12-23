package top.yeonon.ysera.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: yeonon
 * @date: 2019/12/23
 */
@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id", length = 11, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number", length = 40, nullable = false)
    private String phoneNumber;

    @Column(name = "password", length = 256, nullable = false)
    private String password;

    @Column(name = "nickname", length = 40, nullable = false)
    private String nickname;

    @Column(name = "gender", length = 2, nullable = false)
    private int gender;

    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    public User(String phoneNumber, String password, String nickname, int gender) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.nickname = nickname;
        this.gender = gender;
        createTime = new Date();
        updateTime = createTime;
    }
}
