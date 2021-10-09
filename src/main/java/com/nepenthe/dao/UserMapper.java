package com.nepenthe.dao;

import com.nepenthe.pojo.Students;
import com.nepenthe.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 添加新用户
     * @return
     */
    int addUser(@Param("user") User user);

    User queryUserByopenId(@Param("openId") String openId);
}
