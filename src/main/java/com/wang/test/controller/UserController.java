package com.wang.test.controller;

import com.wang.test.entity.User;
import com.wang.test.service.IUserService;
import com.wang.test.util.JsonObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "queryAll")
    @ResponseBody
    public JsonObject queryAll( @Param("limit") Integer limit, @Param("page") Integer page){
        if (limit==null&&page==null){
            limit = new Integer(10);
            page = new Integer(1);
        }
        Integer offset = (page - 1) * limit;
        List<User> list = userService.queryAll(offset,limit);
        JsonObject<User> obj = new JsonObject<>();
        obj.setCode(0);
        obj.setMsg("");
        obj.setCount((long) 50);
        obj.setData(list);
        return obj;
    }
    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
    @RequestMapping(value = "user/userAdd")
    @ResponseBody
    public String deptAdd(User user){
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userService.userAdd(user);
        return "200";
    }
    @RequestMapping(value = "/updateUser")
    @ResponseBody
    public String updateUser(User user){
        user.setUpdateTime(new Date());
        userService.updateUser(user);
        return "200";
    }
    @RequestMapping(value = "/deleteUser")
    @ResponseBody
    public String deleteUser(Integer id){
        userService.deleteUserById(id);
        return "200";
    }
    @RequestMapping(value = "/userSearch")
    @ResponseBody
    public JsonObject search(@Param("mobile")String mobile, @Param("sex")String sex, @Param("address")String address
            , @Param("limit") Integer limit, @Param("page") Integer page){

        if (limit==null&&page==null){
            limit = new Integer(10);
            page = new Integer(1);
        }
        Integer offset = (page - 1) * limit;
        List<User> list;
        if (mobile.equals("")){
            if (sex.equals("")){
                if (address.equals("")){
                    list = userService.queryAll(offset,limit);
                }else {
                    list = userService.queryUserByAddress(address,offset,limit);
                }
            }else if (address.equals("")){
                list = userService.queryUserBySex(sex,offset,limit);
            }else {
                list = userService.queryUserBySexAndAddress(sex,address,offset,limit);
            }
        }else if (sex.equals("")){
            if (address.equals("")){
                list = userService.queryUserByMobile(mobile,offset,limit);
            }else {
                list = userService.queryUserByMobileAndAddress(mobile,address,offset,limit);
            }
        }else if (address.equals("")){
            list = userService.queryUserByMobileAndSex(mobile,sex,offset,limit);
        }else {
            list = userService.queryUserByMobileAndSexAndAddress(mobile,sex,address,offset,limit);
        }
        JsonObject obj = new JsonObject();
        obj.setCode(0);
        obj.setMsg("");
        obj.setCount((long) list.size());
        obj.setData(list);
        return obj;
    }
}
