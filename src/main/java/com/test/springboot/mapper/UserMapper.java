package com.test.springboot.mapper;

import com.test.springboot.domain.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author清梦
 * @site www.xiaomage.com
 * @company xxx公司
 * @create 2020-10-24 9:04
 */
@Repository
public interface UserMapper extends Mapper<User> {

}
