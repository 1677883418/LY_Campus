package com.nepenthe.service;

import com.nepenthe.dao.UserMapper;
import com.nepenthe.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author goodsir
 */
@Service
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
    public User queryUserByOpenId(String openId) {
        return userMapper.queryUserByOpenId(openId);
    }


}
