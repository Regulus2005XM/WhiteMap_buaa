package com.whitemap.whitespringboot3.controller;


import org.springframework.web.bind.annotation.*;

@CrossOrigin //忽略跨域
@RequestMapping("/register") //公共路径
@RestController
public class RegisterController{
    @PostMapping("/reg01")
    public String handleReviewRequest(@RequestBody String form){
        System.out.println(form);
        return "测试用例";
    }
}
