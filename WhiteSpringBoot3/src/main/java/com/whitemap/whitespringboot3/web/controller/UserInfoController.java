package com.whitemap.whitespringboot3.web.controller;

import com.whitemap.whitespringboot3.util.JWTUtil;
import com.whitemap.whitespringboot3.web.controller.response.ResponseMessage;
import com.whitemap.whitespringboot3.DB.pojo.UserPOJO;
import com.whitemap.whitespringboot3.service.IUserService;
import com.whitemap.whitespringboot3.util.TimeUtil;
import com.whitemap.whitespringboot3.web.dto.User.JwtDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/userinfo")
@RestController
public class UserInfoController {

    @Autowired
    IUserService userService;

    /**
     * 根据jwt来获得当前用户的信息
     * @param jwt 用户令牌
     * @return
     */
    @PostMapping
    public ResponseMessage<UserPOJO> getUserInfo(@RequestBody JwtDTO jwt) {
        Integer id = Integer.parseInt(JWTUtil.getUserIdFromJwt(jwt.getJwt0()));
        UserPOJO data = userService.get(id);
        if (data == null)
            return ResponseMessage.info(null,"User not found", HttpStatus.BAD_REQUEST);
        return ResponseMessage.success(data);
    }
}
