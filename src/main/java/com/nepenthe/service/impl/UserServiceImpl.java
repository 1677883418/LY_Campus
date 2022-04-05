package com.nepenthe.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nepenthe.dao.UserMapper;
import com.nepenthe.pojo.User;
import com.nepenthe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author goodsir
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    /**
     * service调dao层:组合dao层
     */
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public User queryUserByOpenId(String openId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("open_id", openId);
        return userMapper.selectOne(queryWrapper);
    }


}
