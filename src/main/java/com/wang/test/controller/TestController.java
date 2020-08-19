package com.wang.test.controller;

import com.wang.test.entity.User;
import com.alibaba.fastjson.JSONObject;
import com.wang.test.service.IUserService;
import com.wang.test.util.JsonObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {

    @RequestMapping(value = "/test")
    public String test(){
        return "query";
    }

}
