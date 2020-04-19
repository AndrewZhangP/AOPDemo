package com.zpeng.controller;

import com.zpeng.pojo.User;
import com.zpeng.service.UserService;
import com.zpeng.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService = null;

    @RequestMapping("/print")
    @ResponseBody
    public User printUser(String id, String userName, String note){
        User user = new User(id,userName,note);
        userService.printUser(user);
        return user;
    }

    @RequestMapping("/vp")
    @ResponseBody
    public User validateAndPrint(String id, String userName, String note){
        User user = new User(id,userName,note);

        UserValidator userValidator = (UserValidator) userService;

        if(userValidator.validate(user)){
            userService.printUser(user);
        }
        return user;
    }
}
