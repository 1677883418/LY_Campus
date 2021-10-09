package com.nepenthe.service;

import com.nepenthe.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author goodsir
 */
public interface UserService {

    /**
     * 添加新用户
     *
     */
    int addUser(@Param("user") User user);
}
