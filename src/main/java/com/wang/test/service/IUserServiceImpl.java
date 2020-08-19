package com.wang.test.service;

import com.wang.test.dao.IUserDao;
import com.wang.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class IUserServiceImpl implements IUserService{
    @Autowired
    private IUserDao userDao;
    @Override
    public List<User> queryAll(Integer offset,Integer limit) {
        return userDao.queryAll(offset,limit);
    }

    @Override
    public void userAdd(User user) {
        userDao.userAdd(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userDao.deleteUserById(id);
    }

    @Override
    public List<User> queryUserByAddress(String address, Integer offset, Integer limit) {
        return userDao.queryUserByAddress(address,offset,limit);
    }

    @Override
    public List<User> queryUserBySex(String sex, Integer offset, Integer limit) {
        return userDao.queryUserBySex(sex,offset,limit);
    }

    @Override
    public List<User> queryUserBySexAndAddress(String sex, String address, Integer offset, Integer limit) {
        return userDao.queryUserBySexAndAddress(sex,address,offset,limit);
    }

    @Override
    public List<User> queryUserByMobile(String mobile, Integer offset, Integer limit) {
        return userDao.queryUserByMobile(mobile,offset,limit);
    }

    @Override
    public List<User> queryUserByMobileAndAddress(String mobile, String address, Integer offset, Integer limit) {
        return userDao.queryUserByMobileAndAddress(mobile,address,offset,limit);
    }

    @Override
    public List<User> queryUserByMobileAndSex(String mobile, String sex, Integer offset, Integer limit) {
        return userDao.queryUserByMobileAndSex(mobile,sex,offset,limit);
    }

    @Override
    public List<User> queryUserByMobileAndSexAndAddress(String mobile, String sex, String address, Integer offset, Integer limit) {
        return userDao.queryUserByMobileAndSexAndAddress(mobile,sex,address,offset,limit);
    }
}
