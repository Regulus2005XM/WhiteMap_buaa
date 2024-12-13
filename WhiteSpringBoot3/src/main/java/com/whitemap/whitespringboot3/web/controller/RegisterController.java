package com.whitemap.whitespringboot3.web.controller;

import com.whitemap.whitespringboot3.DB.pojo.UserPOJO;
import com.whitemap.whitespringboot3.service.IUserService;
import com.whitemap.whitespringboot3.DB.pojo.ResponseMessage;
import com.whitemap.whitespringboot3.web.dto.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin //忽略跨域
@RequestMapping("/register") //公共路径
@RestController
public class RegisterController{

    @Autowired
    IUserService userService;

    @PostMapping("/register")
    public ResponseMessage<UserPOJO> register(@RequestBody RegisterDTO dto){

        UserPOJO user = userService.add(dto);
        return ResponseMessage.success(user);
    }
}
