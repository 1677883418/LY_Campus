package com.nepenthe.controller;

import com.nepenthe.dto.DynamicDTO;
import com.nepenthe.dto.DynamicImageDTO;
import com.nepenthe.pojo.Dynamic;
import com.nepenthe.pojo.DynamicImage;
import com.nepenthe.service.DynamicImageService;
import com.nepenthe.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author GoodSir
 */
@RestController
@RequestMapping("/DynamicImage")
@Api(tags = "动态图片")
public class DynamicImageController {
    @Autowired
    private DynamicImageService dynamicImageService;

    @PostMapping("/addDynamicImage")
    @ApiOperation(value = "添加新动态图片", httpMethod = "POST", notes = "添加新动态图片")
    public Result<Object> addDynamic(@RequestBody DynamicImageDTO dynamicImageDTO) {
        DynamicImage dynamicImage = new DynamicImage();
        BeanUtils.copyProperties(dynamicImageDTO, dynamicImage);
        dynamicImage.setImageTime(LocalDateTime.now());
        return Result.ofSuccess(dynamicImageService.addDynamicImage(dynamicImage));

    }
}
