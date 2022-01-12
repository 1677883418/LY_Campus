package com.nepenthe.service.impl;

import com.nepenthe.dao.DynamicMapper;
import com.nepenthe.dto.DynamicDTO;
import com.nepenthe.pojo.Dynamic;
import com.nepenthe.pojo.DynamicImage;
import com.nepenthe.service.DynamicService;
import com.nepenthe.utils.AliyunOSSUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author goodsir
 */
@Service
public class DynamicServiceImpl implements DynamicService {
    @Autowired
    private DynamicMapper dynamicMapper;
    @Autowired
    private AliyunOSSUtil aliyunOSSUtil;

    @Override
    public Integer addDynamic(DynamicDTO dynamicDTO) {
        ArrayList<String> imgLists = new ArrayList<String>();
        dynamicDTO.getImgBase64Lists().forEach(imgBase64 -> {
            //依次上传图片并接收返回的图片链接
            imgLists.add(aliyunOSSUtil.upload(imgBase64));
        });
        Dynamic dynamic = new Dynamic();
        BeanUtils.copyProperties(dynamicDTO, dynamic);
        return dynamicMapper.addDynamic(dynamic);
        //保存之后这个动态的id会回填
        dynamic.getId();
        imgLists.forEach(img->{
            DynamicImage dynamicImage = new DynamicImage();
            dynamicImage.set
        });
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
