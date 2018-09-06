package hello;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/22 13:25  by  王帅（wangshuai@cloud-young.com）创建
 */
//@Table(name="")//表名和实体类名相同的话，@Table可以省略
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_name")//@Column中指定数据中字段名，
    // 如果字段名与列名相同，则可以省略
    //字段名带下划线查询时报错，可以借助该注解映射解决
    private String username;
    @Column(name = "create_time")
    private LocalDateTime createTime = LocalDateTime.now();
    //时间戳格式 Long createTime=   LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));//LocaDateTIme.toInstant(ZoneOffset.of("+8")).toEpochMilli()
    @Column(name = "email")
    private String email;
    @Column(name = "pass_word")
    private String password;

    public User() {
    }

    public User(String user_name, String email, String password) {
        this.username = user_name;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return username;
    }

    public void setUser_name(String user_name) {
        this.username = user_name;
    }


}
