package com.market.controller;

import com.market.model.User;
import com.market.model.UserResult;
import com.market.service.LogAndSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Simon
 */

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private LogAndSignService logAndSignService;
    @ResponseBody
    @PostMapping("/login")
    public UserResult login(@RequestBody User user){
        return logAndSignService.login(user);
    }
    @ResponseBody
    @PostMapping("/signUp")
    public UserResult signUp(@RequestBody User user){
        return logAndSignService.signUp(user);
    }
}
