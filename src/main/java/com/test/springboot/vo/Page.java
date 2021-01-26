package com.test.springboot.vo;

import lombok.Data;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * @author清梦
 * @site www.xiaomage.com
 * @company xxx公司
 * @create 2020-10-25 9:20
 */
@Data
public class Page<T> {
    private List<T> dates;//当前页的数据
    private Integer totalPage;//总页数
    private long totalNum;//总记录数

}
