package com.market.controller;

import com.market.model.*;
import com.market.service.ChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Simon
 */

@Controller
@RequestMapping("/change")
public class ChangeController {
    @Autowired
    private ChangeService changeService;
    @ResponseBody
    @PostMapping("/user")
    boolean updateUser(@RequestBody User user){
        return changeService.updateUser(user);
    }
    @ResponseBody
    @PostMapping("/item")
    boolean addItem(@RequestBody Item item){
        return changeService.addItem((item));
    }
    @ResponseBody
    @PostMapping("/buy")
    boolean buy(@RequestBody Param param){
        return changeService.buy(param);
    }
    @ResponseBody
    @PostMapping("/record")
    List<Record> getRecord(@RequestBody User user){
        return changeService.getRecord(user);
    }
    @ResponseBody
    @PostMapping("/comment")
    boolean makeComment(@RequestBody Comment comment){
        return changeService.makeComment(comment);
    }
}
