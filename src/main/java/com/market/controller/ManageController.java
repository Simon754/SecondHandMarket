package com.market.controller;

import com.market.model.Item;
import com.market.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manage")
public class ManageController {
    @Autowired
    private ManageService manageService;

    @ResponseBody
    @RequestMapping("/delete")
    boolean deleteItem(@RequestBody Item item){
        return manageService.deleteItem(item);
    }
    @ResponseBody
    @RequestMapping("/pass")
    boolean passItem(@RequestBody Item item){
        return manageService.passItem(item);
    }
}
