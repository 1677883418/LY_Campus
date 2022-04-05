package com.nepenthe.controller;

import com.nepenthe.utils.AliyunOSSUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/Upload")
@Api(tags = "OSS上传接口")
public class UploadController {
    @Autowired
    AliyunOSSUtil aliyunOSSUtil;

    /**
     * 头像上传
     *
     * @return 头像链接
     */
    @PostMapping(value = "/avatar")
    @ApiOperation(value = "上传头像")
    public String uploadAvatar(@RequestParam("avatar") MultipartFile avatar, @RequestParam("openId") String openId) {
        String fileName = avatar.getOriginalFilename();
        fileName = fileName.replace(fileName.substring(0, fileName.indexOf(".")), openId);
        try {
            String uploadUrl = aliyunOSSUtil.upload(avatar, "avatar", fileName);
            return uploadUrl;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 动态图片上传
     *
     * @return 动态链接
     */
    @PostMapping(value = "/dynamicImage")
    @ApiOperation(value = "上传动态图片")
    public String uploadDynamicImage(@RequestParam("dynamicImage") MultipartFile dynamicImage, @RequestParam("dynamicId") String dynamicId) {
        String fileName = dynamicImage.getOriginalFilename();
        try {
//            String uploadUrl = aliyunOSSUtil.upload(dynamicImage, "DynamicImage", fileName);
            String uploadUrl = aliyunOSSUtil.upload(dynamicImage, "DynamicImage/"+dynamicId, fileName);
            return uploadUrl;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}