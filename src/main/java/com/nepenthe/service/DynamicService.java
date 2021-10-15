package com.nepenthe.service;

import com.nepenthe.pojo.Dynamic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author goodsir
 */
public interface DynamicService {
    /**
     * @param dynamic
     * @return 添加的动态
     */
    Dynamic addDynamic(@Param("dynamic") Dynamic dynamic);

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
