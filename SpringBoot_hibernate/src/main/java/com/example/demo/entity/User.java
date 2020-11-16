package com.example.demo.entity;

import com.example.demo.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @类名称 User.java
 * @类描述 <pre>用户实体</pre>
 * @作者  xingsfdz xingsfdz@163.com
 * @创建时间 2019年12月19日 下午6:05:28
 * @版本 1.00
 *
 * @修改记录
 * <pre>
 *     版本                       修改人 		修改日期 		 修改内容描述
 *     ----------------------------------------------
 *     1.00 	xingsfdz 	2019年12月19日
 *     ----------------------------------------------
 * </pre>
 */
@Entity
@Table(name = "xbc_user")
public class User extends BaseEntity {

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [userName=" + userName + ", password=" + password + "]";
    }

//    @OneToOne(mappedBy = )
//    private
}


