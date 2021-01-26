package com.test.springboot.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.springboot.domain.User;
import com.test.springboot.mapper.UserMapper;
import com.test.springboot.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author清梦
 * @site www.xiaomage.com
 * @company xxx公司
 * @create 2020-10-24 9:03
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public boolean checkLogin(String username, String password) {
        User user=new User();
        user.setUsername(username);
        User res=userMapper.selectOne(user);
        if (res!=null){
            if (res.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public List<User> list(){
        List<User> users = userMapper.selectAll();
        return users;
    }

    public User get(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User add(User user){
       userMapper.insert(user);
       return user;
    }

    public boolean delete(Integer id){
        return userMapper.deleteByPrimaryKey(id)>0;
    }
    public boolean update(User user){
       return userMapper.updateByPrimaryKeySelective(user)>0;
    }
    public List<User> search(String keyword){
        Example example=new Example(User.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andLike("username","%"+keyword+"%");
        return userMapper.selectByExample(example);

    }
    public Page<User> page(Integer page,Integer size){
        PageHelper.startPage(page,size);
        List<User> list = userMapper.selectAll();
        PageInfo<User> pageInfo=new PageInfo<>(list);
        Page myPage=new Page();
        myPage.setDates(list);
        myPage.setTotalPage(pageInfo.getPages());
        myPage.setTotalNum(pageInfo.getTotal());
        return myPage;
    }

    public void edit(User user) {

        userMapper.updateByPrimaryKey(user);
    }

    public User findUserById(int id) {
       return userMapper.selectByPrimaryKey(id);
    }
}
