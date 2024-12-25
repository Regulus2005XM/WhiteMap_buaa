package com.whitemap.whitespringboot3.web.controller;

import com.whitemap.whitespringboot3.DB.pojo.UserPOJO;
import com.whitemap.whitespringboot3.service.IUserService;
import com.whitemap.whitespringboot3.DB.pojo.ResponseMessage;
import com.whitemap.whitespringboot3.util.PasswordHashUtil;
import com.whitemap.whitespringboot3.util.UserInfoValidator;
import com.whitemap.whitespringboot3.web.dto.User.LoginDTO;
import com.whitemap.whitespringboot3.web.dto.User.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@CrossOrigin //忽略跨域
@RequestMapping("/register") //公共路径
@RestController
public class RegisterController{

    @Autowired
    IUserService userService;

    @PostMapping("/register")
    public ResponseMessage<UserPOJO> register(@RequestBody RegisterDTO dto){
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
        return ResponseMessage.success(user);
    }

    @PostMapping("/login")
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
