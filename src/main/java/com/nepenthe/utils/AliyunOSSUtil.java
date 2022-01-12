package com.nepenthe.utils;


import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.io.file.FileReader;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectResult;
import com.nepenthe.utils.Base64.Base64Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class AliyunOSSUtil {
    private String endpoint;
    private String keyId;
    private String keySecret;
    private String bucketName;
    private String fileHost;

    @Value("${OSS.file.endpoint}")
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @Value("${OSS.file.keyId}")
    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    @Value("${OSS.file.keySecret}")
    public void setKeySecret(String keySecret) {
        this.keySecret = keySecret;
    }

    @Value("${OSS.file.bucketName}")
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    @Value("${OSS.file.fileHost}")
    public void setFileHost(String fileHost) {
        this.fileHost = fileHost;
    }
    public String upload(String file) {
        MultipartFile multipart = Base64Util.base64ToMultipart(file);
        String fileType=Base64Util.checkImageBase64Format(file);
        String fileName = String.format("%s.%s", UUID.randomUUID().toString().replaceAll("-", ""), multipart.getOriginalFilename());
        return this.upload(multipart,fileType,fileName);
    }

    public  String upload(MultipartFile file, String fileType, String fileName) {
        OSS ossClient = null;
        String fileUrl = null;
        //文件新路径
        try {
            /*            //获取当前日期
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = format.format(new Date());*/
            ossClient = new OSSClientBuilder().build(this.endpoint, this.keyId, this.keySecret);
            //创建文件路径
            //String fileUrl = fileHost + "/" + (dateStr + "/" + UUID.randomUUID().toString().replace("-", "") + "-" + fileName);
            fileUrl = this.fileHost + "/" + fileType + "/" + fileName;

            // 上传到阿里云
            PutObjectResult result = ossClient.putObject(this.bucketName, fileUrl, file.getInputStream());
            return "https://" + this.bucketName + "." + this.endpoint + "/" + fileUrl;

        } catch (OSSException | ClientException | IOException oe) {
        } finally {
            //关闭
            ossClient.shutdown();
        }
        return null;
    }
//    public  String delete()

}
