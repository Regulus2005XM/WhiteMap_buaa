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

@CrossOrigin //忽略跨域
@RequestMapping("/userupdate") //公共路径
@RestController
public class UserUpdateController {
    static Long nameChangeGap = TimeUtil.time2Seconds(3,0,0,0);

    @Autowired
    IUserService userService;

    @PostMapping
    public ResponseMessage<UserPOJO> updateInfo(@RequestBody UserInfoDTO dto) throws IOException {
        Boolean updated = false;
        UserPOJO pojo = userService.get(dto.getId());
        if(pojo == null)
            return ResponseMessage.info(null,"User not found", HttpStatus.BAD_REQUEST);
        if(dto.getUsername() != null)
        {
            //时间校验
            if(TimeUtil.getSecondsSince(pojo.getLastNameChange()) < nameChangeGap)
                return ResponseMessage.info(null,"Name change requests are too frequent", HttpStatus.BAD_REQUEST);
            //格式校验
            if(!UserInfoValidator.isValidUsername(dto.getUsername()))
                return ResponseMessage.info(null,"Invalid username", HttpStatus.BAD_REQUEST);
            //数据库校验
            if(userService.accountExists(dto.getUsername()))
                return ResponseMessage.info(null,"Username already exists", HttpStatus.BAD_REQUEST);
            updated = true;
            pojo.setUsername(dto.getUsername());
        }
        if(dto.getBirthday() != null)
        {
            updated = true;
            pojo.setBirthday(dto.getBirthday());
        }
        if(dto.getGender() != null)
        {
            updated = true;
            pojo.setGender(dto.getGender());
        }
        if (dto.getDescription()!=null)
        {
            updated = true;
            pojo.setDescription(dto.getDescription());
        }
        if(!dto.getImageFile().isEmpty())
        {
            updated = true;
            pojo.setImageURL(ImageUtil.uploadImage(dto.getImageFile()));
        }
        if(updated)
            userService.save(pojo);
        return ResponseMessage.success(pojo);
    }
}
