package com.nepenthe.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nepenthe.dao.DynamicImageMapper;
import com.nepenthe.dto.DynamicDTO;
import com.nepenthe.pojo.DynamicImage;
import com.nepenthe.service.DynamicImageService;
import com.nepenthe.vo.DynamicVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LengAo
 * @since 2022-01-12
 */
@Service
public class DynamicImageServiceImpl extends ServiceImpl<DynamicImageMapper, DynamicImage> implements DynamicImageService {
    @Autowired
    private DynamicImageMapper dynamicImageMapper;

    @Override
    public int addDynamicImage(DynamicImage dynamicImage) {
        return dynamicImageMapper.insert(dynamicImage);
    }

    @Override
    public Integer deleteDynamic(Integer dynamicImageId) {
        return dynamicImageMapper.deleteById(dynamicImageId);
    }

    @Override
    public Integer updateDynamic(DynamicDTO dynamicDTO) {
        return null;
    }

    @Override
    public List<DynamicVO> queryAllDynamicByUserId(Integer userId) {
        return null;
    }
}
