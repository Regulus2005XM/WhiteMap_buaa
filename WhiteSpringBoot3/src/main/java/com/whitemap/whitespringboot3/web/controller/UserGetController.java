package com.whitemap.whitespringboot3.web.controller;

import com.whitemap.whitespringboot3.web.controller.response.ResponseMessage;
import com.whitemap.whitespringboot3.DB.pojo.UserPOJO;
import com.whitemap.whitespringboot3.service.IUserService;
import com.whitemap.whitespringboot3.util.ImageUtil;
import com.whitemap.whitespringboot3.util.TimeUtil;
import com.whitemap.whitespringboot3.util.UserInfoValidator;
import com.whitemap.whitespringboot3.web.dto.User.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:5173") //忽略跨域
@RequestMapping("/userget") //公共路径
@RestController
public class UserGetController {
    static Long nameChangeGap = TimeUtil.time2Seconds(3,0,0,0);

    @Autowired
    IUserService userService;

    @GetMapping
    public ResponseMessage<UserPOJO> getUserInfo(@RequestParam Integer id) {
        UserPOJO data = userService.get(id);
        if (data == null)
            return ResponseMessage.info(null,"User not found", HttpStatus.BAD_REQUEST);
        return ResponseMessage.success(data);
    }
}
