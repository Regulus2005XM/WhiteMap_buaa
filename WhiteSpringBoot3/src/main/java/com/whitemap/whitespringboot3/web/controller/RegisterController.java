package com.whitemap.whitespringboot3.web.controller;


import com.whitemap.whitespringboot3.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
public class RegisterController{
    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public String showUserProfilePage(@RequestParam(value = "tab", required = false) String tabType,
                                      @PathVariable Long userId, Model model) {
        if (null == userId) {
            throw new BadRequestException("Path variable userId cound not be null.");
        }
        Map<String, Object> attributes = this.userService.getUserProfileAndPostsByUserIdByTabType(userId, tabType);
        if (null == attributes) {
            throw new ResourceNotFoundException("attributes not found.");
        }
        model.addAllAttributes(attributes);
        return "forum/user-profile";
    }


    @PostMapping("/reg01")
    public String handleReviewRequest(@RequestBody String form){
        System.out.println(form);
        return "测试用例";
    }
}

