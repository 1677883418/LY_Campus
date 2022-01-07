package com.nepenthe.service;

import com.nepenthe.dao.DynamicMapper;
import com.nepenthe.pojo.Dynamic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author goodsir
 */
@Service
public class DynamicServiceImpl implements DynamicService {
    @Autowired
    private DynamicMapper dynamicMapper;

    @Override
    public Integer addDynamic(Dynamic dynamic) {
        return dynamicMapper.addDynamic(dynamic);
    }

    @Override
    public Integer deleteDynamic(Integer dynamicId) {
        return dynamicMapper.deleteDynamic(dynamicId);
    }

    @Override
    public Integer updateDynamic(Integer dynamicId) {
        return dynamicMapper.updateDynamic(dynamicId);
    }

    @Override
    public List<Dynamic> queryAllDynamicByUserId(Integer userId) {
        return dynamicMapper.queryAllDynamicByUserId(userId);
    }
}
