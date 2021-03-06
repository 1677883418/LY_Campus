package com.nepenthe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nepenthe.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author goodsir
 */
@Repository
public interface UserMapper  extends BaseMapper<User> {

}
