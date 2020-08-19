package com.wang.test.service;

import com.wang.test.entity.User;

import java.util.List;

public interface IUserService {
    List<User> queryAll(Integer offset,Integer limit);

    void userAdd(User user);

    void updateUser(User user);

    void deleteUserById(Integer id);

    List<User> queryUserByAddress(String address, Integer offset, Integer limit);

    List<User> queryUserBySex(String sex, Integer offset, Integer limit);

    List<User> queryUserBySexAndAddress(String sex, String address, Integer offset, Integer limit);

    List<User> queryUserByMobile(String mobile, Integer offset, Integer limit);

    List<User> queryUserByMobileAndAddress(String mobile, String address, Integer offset, Integer limit);

    List<User> queryUserByMobileAndSex(String mobile, String sex, Integer offset, Integer limit);

    List<User> queryUserByMobileAndSexAndAddress(String mobile, String sex, String address, Integer offset, Integer limit);
}
