package com.nepenthe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nepenthe.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author goodsir
 */
public interface UserService  extends IService<User> {
    /**
     * 添加新用户
     *
     * @return 添加是否成功
     */
    Integer addUser(@Param("user") User user);

    /**
     * @param user 需要更改的用户
     * @return 更改是否成功
     */
    Integer updateUser(@Param("user") User user);

    /**
     * @param openId 小程序用户标识
     * @return 根据openId查询库中有无该对象
     */
    User queryUserByOpenId(@Param("openId") String openId);
}
