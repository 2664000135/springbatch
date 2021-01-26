package com.test.springboot.controller;

import com.test.springboot.Service.UserService;
import com.test.springboot.domain.User;
import com.test.springboot.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author清梦
 * @site www.xiaomage.com
 * @company xxx公司
 * @create 2020-10-24 9:03
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    @ResponseBody
    public List<User> list(){
        return userService.list();

    }
    @GetMapping("/get/{id}")
    @ResponseBody
    public User get(@PathVariable("id") Integer id){
        return userService.get(id);

    }
    @PostMapping("/save")
    @ResponseBody
    public User save(User user){
        return userService.add(user);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public boolean delete(Integer id){
        return userService.delete(id);
    }
    @PutMapping("/update")
    @ResponseBody
    public boolean update(User user){
        return userService.update(user);
    }
    @GetMapping("/search")
    @ResponseBody
    public List<User> search(String keyword){
        return userService.search(keyword);
    }
    @GetMapping("/page")
    @ResponseBody
    public Page<User> page(@RequestParam(value = "page",defaultValue = "1") Integer page,@RequestParam(value = "size",defaultValue = "5") Integer size){
        return userService.page(page,size);
    }

    @GetMapping("/user/list")
    public String userList(@RequestParam (value = "page",defaultValue = "1")Integer page, @RequestParam(value = "size",defaultValue = "5") Integer size, ModelMap map){
        Page<User> pages=userService.page(page,size);
        map.put("page",pages);
        //return "list";
        return "l";
    }
    @RequestMapping("/user/toEdit")
    public String toEdit(Model model, int id){
        User user=userService.findUserById(id);
        model.addAttribute("u",user);
        return "edit";
    }
    @RequestMapping("/user/edit")
    public String edit(User user){
        userService.edit(user);
        return "redirect:/user/list";
    }
    @RequestMapping("/user/toAdd")
    public String toAdd(){
        return "add";
    }
    @PostMapping("/user/add")
    public String add(User user){
        userService.add(user);
        return "redirect:/user/list";
    }
    @RequestMapping("/user/delete")
    public String userDelete(Integer id){
        userService.delete(id);
        return "redirect:/user/list";
    }
}
