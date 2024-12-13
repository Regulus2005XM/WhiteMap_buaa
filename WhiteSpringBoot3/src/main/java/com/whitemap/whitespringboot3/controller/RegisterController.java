package com.whitemap.whitespringboot3.controller;

import com.whitemap.whitespringboot3.pojo.ResponseMessage;
import com.whitemap.whitespringboot3.pojo.UserPOJO;
import com.whitemap.whitespringboot3.pojo.dto.RegisterDTO;
import com.whitemap.whitespringboot3.service.IUserService;
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
