package com.nepenthe.dao;

import com.nepenthe.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    /**
     * 添加新用户
     *
     * @return 添加是否成功
     */
    boolean addUser(@Param("user") User user);

    /**
     *
     * @param user 需要更改的用户
     * @return 更改是否成功
     */
    int updateUser(@Param("user") User user);

    /**
     * @param openId 小程序用户标识
     * @return 根据openId查询库中有无该对象
     */
    User queryUserByopenId(@Param("openId") String openId);
}
