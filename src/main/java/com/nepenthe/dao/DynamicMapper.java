package com.nepenthe.dao;

import com.nepenthe.pojo.Dynamic;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author goodsir
 */
@Repository
public interface DynamicMapper {
    /**
     * @return 添加的动态
     */
    Integer addDynamic(@Param("dynamic") Dynamic dynamic);

    /**
     * @param dynamicId 动态Id
     * @return 删除是否成功
     */
    Integer deleteDynamic(@Param("dynamicId") Integer dynamicId);

    /**
     * @param dynamicId 动态Id
     * @return 更新是否成功
     */
    Integer updateDynamic(@Param("dynamicId") Integer dynamicId);

    /**
     * @param userId 用户Id
     * @return 查询到的动态集合
     */
    List<Dynamic> queryAllDynamicByUserId(@Param("userId") Integer userId);
}
