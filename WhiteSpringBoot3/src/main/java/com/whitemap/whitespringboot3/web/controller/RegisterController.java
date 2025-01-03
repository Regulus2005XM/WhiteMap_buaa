package com.whitemap.whitespringboot3.web.controller;

import com.whitemap.whitespringboot3.DB.pojo.UserPOJO;
import com.whitemap.whitespringboot3.service.IUserService;
import com.whitemap.whitespringboot3.util.JWTUtil;
import com.whitemap.whitespringboot3.web.controller.response.ResponseMessage;
import com.whitemap.whitespringboot3.util.UserInfoValidator;
import com.whitemap.whitespringboot3.web.dto.User.RegisterBackDTO;
import com.whitemap.whitespringboot3.web.dto.User.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RequestMapping("/register")
@RestController
public class RegisterController {

    @Autowired
    IUserService userService;

    @PostMapping
    public ResponseMessage<RegisterBackDTO> register(@RequestBody RegisterDTO dto){
        //格式校验
        if(!UserInfoValidator.isValidAccount(dto.getAccount()))
            return ResponseMessage.info(null,"Invalid Account", HttpStatus.BAD_REQUEST);
        if(!UserInfoValidator.isValidPassword(dto.getPassword()))
            return ResponseMessage.info(null,"Invalid Password", HttpStatus.BAD_REQUEST);
        if(!UserInfoValidator.isValidEmail(dto.getEmail()))
            return ResponseMessage.info(null,"Invalid Email", HttpStatus.BAD_REQUEST);
        //数据库校验
        if(userService.get(dto.getAccount()) != null)
            return ResponseMessage.info(null,"Account already exists", HttpStatus.CONFLICT);
        //添加用户
        UserPOJO user = userService.add(dto);
        //通过
        RegisterBackDTO back = new RegisterBackDTO(JWTUtil.generateToken(user.getId().toString()),user.getId().toString());
        return ResponseMessage.success(back);
    }
}
