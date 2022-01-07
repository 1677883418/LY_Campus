package com.nepenthe.utils;


import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileReader;
import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class AliyunOSSUtil {
    private static String endpoint;
    private static String keyId;
    private static String keySecret;
    private static String bucketName;
    private static String fileHost;

    @Value("${OSS.file.endpoint}")
    public void setEndpoint(String endpoint) {
        AliyunOSSUtil.endpoint = endpoint;
    }

    @Value("${OSS.file.keyId}")
    public void setKeyId(String keyId) {
        AliyunOSSUtil.keyId = keyId;
    }

    @Value("${OSS.file.keySecret}")
    public void setKeySecret(String keySecret) {
        AliyunOSSUtil.keySecret = keySecret;
    }

    @Value("${OSS.file.bucketName}")
    public void setBucketName(String bucketName) {
        AliyunOSSUtil.bucketName = bucketName;
    }

    @Value("${OSS.file.fileHost}")
    public void setFileHost(String fileHost) {
        AliyunOSSUtil.fileHost = fileHost;
    }

    public static String upload(MultipartFile file, String fileType, String fileName) {
        OSS ossClient = null;
        String fileUrl = null;
        //文件新路径
        try {
            /*            //获取当前日期
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dateStr = format.format(new Date());*/
            ossClient = new OSSClientBuilder().build(endpoint, keyId, keySecret);
            //创建文件路径
            //String fileUrl = fileHost + "/" + (dateStr + "/" + UUID.randomUUID().toString().replace("-", "") + "-" + fileName);
            fileUrl = fileHost + "/" + fileType + "/" + fileName;

            // 上传到阿里云
            PutObjectResult result = ossClient.putObject(bucketName, fileUrl, file.getInputStream());
            return "https://" + bucketName + "." + endpoint + "/" + fileUrl;

        } catch (OSSException | ClientException | IOException oe) {
        } finally {
            //关闭
            ossClient.shutdown();
        }
        return null;
    }
//    public static String delete()

}
