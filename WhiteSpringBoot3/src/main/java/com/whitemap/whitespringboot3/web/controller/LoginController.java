package com.whitemap.whitespringboot3.web.controller;

import com.whitemap.whitespringboot3.DB.pojo.UserPOJO;
import com.whitemap.whitespringboot3.service.IUserService;
import com.whitemap.whitespringboot3.web.controller.response.ResponseMessage;
import com.whitemap.whitespringboot3.util.PasswordHashUtil;
import com.whitemap.whitespringboot3.web.dto.User.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
@CrossOrigin
@RequestMapping("/login")
@RestController
public class LoginController {
    @Autowired
    IUserService userService;

    @PostMapping
    public ResponseMessage<UserPOJO> login(@RequestBody LoginDTO dto) throws NoSuchAlgorithmException {
        UserPOJO user = userService.get(dto.getAccount());
        //校验
        if(user == null)
            return ResponseMessage.info(null,"Account not found", HttpStatus.UNAUTHORIZED);
        if(!PasswordHashUtil.checkPassword(dto.getPassword(),user.getPassword()))
            return ResponseMessage.info(null,"Wrong password",HttpStatus.UNAUTHORIZED);
        //通过
        return ResponseMessage.success(user);
    }
}
