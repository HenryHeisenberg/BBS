package controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import data.Result;

@Controller
public class TestRole{

    @ResponseBody
    @RequiresRoles("0")
    @RequestMapping("/admin")
    public Result getAdmin(){
        return new Result("你现在是管理员了",null);
    }

    @ResponseBody
    @RequiresRoles("1")
    @RequestMapping("/user")
    public Result getUser(){
        return new Result("你现在是用户了",null);
    }

}