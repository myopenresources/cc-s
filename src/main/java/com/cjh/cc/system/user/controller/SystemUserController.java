package com.cjh.cc.system.user.controller;

import com.cjh.cc.system.user.model.SystemUser;
import com.cjh.cc.system.user.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/system/user")
public class SystemUserController {

    @Autowired
    private SystemUserService userService;

    @RequestMapping(value = "/saveUser", method = RequestMethod.GET)
    public Object saveUser()throws Exception {
        SystemUser user =new SystemUser();
        user.setId("122");
        user.setUserName("张三");
        return this.userService.saveUser(user);
    }

    @RequestMapping(value = "/findList", method = RequestMethod.POST)
    public Object findList()throws Exception {
        List<SystemUser> list=new ArrayList<>();
        for(int i=0;i<15;i++){
            SystemUser user=new SystemUser();
            user.setId(i+"-0");
            user.setUserName("admin"+i);
            list.add(user);
        }

        Map<String,Object> map=new HashMap<>();
        map.put("rows",list);
        map.put("total",80);
        return map;
    }
}
