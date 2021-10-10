package com.nepenthe.service;

import com.nepenthe.dao.UserMapper;
import com.nepenthe.pojo.User;

/**
 * @author goodsir
 */
public class UserServiceImpl implements UserService {

    /**
     * service调dao层:组合dao层
     */
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User queryUserByopenId(String openId) {
        return userMapper.queryUserByopenId(openId);
    }


}
