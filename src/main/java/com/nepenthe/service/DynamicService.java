package com.nepenthe.service;

import com.nepenthe.dto.DynamicDTO;
import com.nepenthe.pojo.Dynamic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author goodsir
 */
public interface DynamicService {
    /**
     * @param dynamicDTO
     * @return 添加的动态
     */
    Integer addDynamic(@Param("dynamic") DynamicDTO dynamicDTO);

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
