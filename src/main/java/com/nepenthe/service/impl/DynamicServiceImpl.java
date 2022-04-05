package com.nepenthe.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nepenthe.dao.DynamicMapper;
import com.nepenthe.dao.DynamicImageMapper;
import com.nepenthe.dto.DynamicDTO;
import com.nepenthe.pojo.Dynamic;
import com.nepenthe.service.DynamicService;
import com.nepenthe.vo.DynamicVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author goodsir
 */
@Service
public class DynamicServiceImpl extends ServiceImpl<DynamicMapper, Dynamic> implements DynamicService {
    @Autowired
    private DynamicMapper dynamicMapper;

    @Autowired
    private DynamicImageMapper dynamicImageMapper;

    @Override
    public int addDynamic(Dynamic dynamic) {
        return dynamicMapper.insert(dynamic);
    }

    @Override
    public Integer deleteDynamic(Integer dynamicId) {
        return dynamicMapper.deleteById(dynamicId);
    }

    @Override
    public Integer updateDynamic(DynamicDTO dynamicDTO) {
        Dynamic dynamic = new Dynamic();
        BeanUtils.copyProperties(dynamicDTO, dynamic);
        return dynamicMapper.updateById(dynamic);
    }

    @Override
    public List<DynamicVO> queryAllDynamicByUserId(Integer userId) {
        QueryWrapper<Dynamic> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return dynamicMapper.selectList(queryWrapper).stream().map(dynamic -> {
            DynamicVO dynamicVO = new DynamicVO();
            BeanUtils.copyProperties(dynamic, dynamicVO);
            return dynamicVO;
        }).collect(Collectors.toList());
    }

    @Override
    public List<DynamicVO> queryAllDynamic() {
        return dynamicMapper.queryAllDynamic();
    }
}
