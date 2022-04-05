package com.nepenthe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nepenthe.dto.DynamicDTO;
import com.nepenthe.pojo.Dynamic;
import com.nepenthe.vo.DynamicVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author goodsir
 */
@Repository
public interface DynamicMapper extends BaseMapper<Dynamic> {
    /**
     * 查询所有动态
     *
     * @return 动态接收类
     */
    List<DynamicVO> queryAllDynamic();
}
