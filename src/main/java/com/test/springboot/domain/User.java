package com.test.springboot.domain;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author清梦
 * @site www.xiaomage.com
 * @company xxx公司
 * @create 2020-10-24 8:56
 */
@Data
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String gender;
    private Date createAt;
}
