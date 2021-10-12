package com.nepenthe.service;

import com.nepenthe.dao.UserMapper;
import com.nepenthe.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author goodsir
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * service调dao层:组合dao层
     */
    @Autowired
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User queryUserByOpenId(String openId) {
        return userMapper.queryUserByOpenId(openId);
    }


}
