package com.nepenthe.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nepenthe.dto.DynamicDTO;
import com.nepenthe.pojo.Dynamic;
import com.nepenthe.vo.DynamicVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author goodsir
 */
public interface DynamicService extends IService<Dynamic> {
    /**
     * @return 添加的动态
     */
    int addDynamic(Dynamic dynamic);

    /**
     * @param dynamicId 动态Id
     * @return 删除是否成功
     */
    Integer deleteDynamic(@Param("dynamicId") Integer dynamicId);

    /**
     * @return 更新是否成功
     */
    Integer updateDynamic(@Param("dynamicId") DynamicDTO dynamicDTO);

    /**
     * @param userId 用户Id
     * @return 查询到的动态集合
     */
    List<DynamicVO> queryAllDynamicByUserId(@Param("userId") Integer userId);

    /**
     * 查询所有动态
     * @return
     */
    List<DynamicVO> queryAllDynamic();
}
