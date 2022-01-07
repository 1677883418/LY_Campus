package com.nepenthe.utils.OSS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.aliyun.oss.*;
import com.aliyun.oss.model.DeleteObjectsRequest;
import com.aliyun.oss.model.DeleteObjectsResult;
import com.aliyun.oss.model.GenericRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author AggerChen
 * @ClassName: OSSUploadUtil
 * @Description: 阿里云OSS文件上传工具类
 * @date 2016年11月3日 下午12:03:24
 */
@Component
public class OSSUploadUtil {
    /**
     * 节点
     * ID
     * 密钥
     * bucket名称
     * 文件路径
     */
    private static String endpoint;
    private static String keyId;
    private static String keySecret;
    private static String bucketName;
    private static String fileHost;


    @Value("${OSS.file.endpoint}")
    public static void setEndpoint(String endpoint) {
        OSSUploadUtil.endpoint = endpoint;
    }

    @Value("${OSS.file.keyId}")
    public void setKeyId(String keyId) {
        OSSUploadUtil.keyId = keyId;
    }

    @Value("${OSS.file.keySecret}")
    public void setKeySecret(String keySecret) {
        OSSUploadUtil.keySecret = keySecret;
    }

    @Value("${OSS.file.bucketName}")
    public void setBucketName(String bucketName) {
        OSSUploadUtil.bucketName = bucketName;
    }

    @Value("${OSS.file.fileHost}")
    public void setFileHost(String fileHost) {
        OSSUploadUtil.fileHost = fileHost;
    }

    /**
     * @param file
     * @param fileType 文件后缀
     * @return String 文件地址
     * @MethodName: uploadFile
     * @Description: OSS单文件上传
     */
    public static String uploadFile(File file, String fileType) {
        //文件名，根据UUID来
        String fileName = fileHost + UUID.randomUUID().toString().toUpperCase().replace("-", "") + "." + fileType;
        return putObject(file, fileType, fileName);
    }

    /**
     * @param file
     * @param fileType
     * @param oldUrl
     * @return String
     * @MethodName: updateFile
     * @Description: 更新文件:只更新内容，不更新文件名和文件地址。
     * (因为地址没变，可能存在浏览器原数据缓存，不能及时加载新数据，例如图片更新，请注意)
     */
    public static String updateFile(File file, String fileType, String oldUrl) {
        String fileName = getFileName(oldUrl);
        if (fileName == null) {
            return null;
        }
        return putObject(file, fileType, fileName);
    }

    /**
     * @param file
     * @param fileType 文件后缀
     * @param oldUrl   需要删除的文件地址
     * @return String 文件地址
     * @MethodName: replaceFile
     * @Description: 替换文件:删除原文件并上传新文件，文件名和地址同时替换
     * 解决原数据缓存问题，只要更新了地址，就能重新加载数据)
     */
    public static String replaceFile(File file, String fileType, String oldUrl) {
        boolean flag = deleteFile(oldUrl);      //先删除原文件
        if (!flag) {
            //更改文件的过期时间，让他到期自动删除。
        }
        return uploadFile(file, fileType);
    }

    /**
     * @param fileUrl 需要删除的文件url
     * @return boolean 是否删除成功
     * @MethodName: deleteFile
     * @Description: 单文件删除
     */
    public static boolean deleteFile(String fileUrl) {
        //根据url获取bucketName
        String bucketName = OSSUploadUtil.getBucketName(fileUrl);
        //根据url获取fileName
        String fileName = OSSUploadUtil.getFileName(fileUrl);
        if (bucketName == null || fileName == null) {
            return false;
        }
        OSS ossClient = null;
        try {
            ossClient = new OSSClientBuilder().build(endpoint, keyId, keySecret);
            GenericRequest request = new DeleteObjectsRequest(bucketName).withKey(fileName);
            ossClient.deleteObject(request);

        } catch (Exception oe) {
            oe.printStackTrace();
            return false;
        } finally {
            ossClient.shutdown();
        }
        return true;
    }

    /**
     * @param fileUrls 需要删除的文件url集合
     * @return int 成功删除的个数
     * @MethodName: batchDeleteFiles
     * @Description: 批量文件删除(较快)：适用于相同endPoint和BucketName
     */
    public static int deleteFile(List<String> fileUrls) {
        //成功删除的个数
        int deleteCount = 0;
        //根据url获取bucketName
        String bucketName = OSSUploadUtil.getBucketName(fileUrls.get(0));
        //根据url获取fileName
        List<String> fileNames = OSSUploadUtil.getFileName(fileUrls);
        if (bucketName == null || fileNames.size() <= 0) {
            return 0;
        }
        OSS ossClient = null;
        try {
            ossClient = new OSSClientBuilder().build(endpoint, keyId, keySecret);
            DeleteObjectsRequest request = new DeleteObjectsRequest(bucketName).withKeys(fileNames);
            DeleteObjectsResult result = ossClient.deleteObjects(request);
            deleteCount = result.getDeletedObjects().size();
        } catch (OSSException oe) {
            oe.printStackTrace();
            throw new RuntimeException("OSS服务异常:", oe);
        } catch (ClientException ce) {
            ce.printStackTrace();
            throw new RuntimeException("OSS客户端异常:", ce);
        } finally {
            ossClient.shutdown();
        }
        return deleteCount;

    }

    /**
     * @param fileUrls 需要删除的文件url集合
     * @return int 成功删除的个数
     * @MethodName: batchDeleteFiles
     * @Description: 批量文件删除(较慢)：适用于不同endPoint和BucketName
     */
    public static int deleteFiles(List<String> fileUrls) {
        int count = 0;
        for (String url : fileUrls) {
            if (deleteFile(url)) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param file
     * @param fileType
     * @param fileName
     * @return String
     * @MethodName: putObject
     * @Description: 上传文件
     */
    private static String putObject(File file, String fileType, String fileName) {
        //默认null
        String url = null;
        OSS ossClient = null;
        try {
            ossClient = new OSSClientBuilder().build(endpoint, keyId, keySecret);
            InputStream input = new FileInputStream(file);
            // 创建上传Object的Metadata
            ObjectMetadata meta = new ObjectMetadata();
            // 设置上传内容类型
            meta.setContentType(OSSUploadUtil.contentType(fileType));
            // 被下载时网页的缓存行为
            meta.setCacheControl("no-cache");
            //创建上传请求
            PutObjectRequest request = new PutObjectRequest(bucketName, fileName, input, meta);
            ossClient.putObject(request);
            //上传成功再返回的文件路径
            url = endpoint.replaceFirst("http://", "http://" + bucketName + ".") + "/" + fileName;
        } catch (OSSException oe) {
            oe.printStackTrace();
            return null;
        } catch (ClientException ce) {
            ce.printStackTrace();
            return null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            ossClient.shutdown();
        }
        return url;
    }

    /**
     * @param fileType
     * @return String
     * @MethodName: contentType
     * @Description: 获取文件类型
     */
    private static String contentType(String fileType) {
        fileType = fileType.toLowerCase();
        String contentType = "";
        switch (fileType) {
            case "bmp":
                contentType = "image/bmp";
                break;
            case "gif":
                contentType = "image/gif";
                break;
            case "png":
            case "jpeg":
            case "jpg":
                contentType = "image/jpeg";
                break;
            case "html":
                contentType = "text/html";
                break;
            case "txt":
                contentType = "text/plain";
                break;
            case "vsd":
                contentType = "application/vnd.visio";
                break;
            case "ppt":
            case "pptx":
                contentType = "application/vnd.ms-powerpoint";
                break;
            case "doc":
            case "docx":
                contentType = "application/msword";
                break;
            case "xml":
                contentType = "text/xml";
                break;
            case "mp4":
                contentType = "video/mp4";
                break;
            default:
                contentType = "application/octet-stream";
                break;
        }
        return contentType;
    }

    /**
     * @param fileUrl 文件url
     * @return String bucketName
     * @MethodName: getBucketName
     * @Description: 根据url获取bucketName
     */
    private static String getBucketName(String fileUrl) {
        String http = "http://";
        String https = "https://";
        int httpIndex = fileUrl.indexOf(http);
        int httpsIndex = fileUrl.indexOf(https);
        int startIndex = 0;
        if (httpIndex == -1) {
            if (httpsIndex == -1) {
                return null;
            } else {
                startIndex = httpsIndex + https.length();
            }
        } else {
            startIndex = httpIndex + http.length();
        }
        int endIndex = fileUrl.indexOf(".oss-");
        return fileUrl.substring(startIndex, endIndex);
    }

    /**
     * @param fileUrl 文件url
     * @return String fileName
     * @MethodName: getFileName
     * @Description: 根据url获取fileName
     */
    private static String getFileName(String fileUrl) {
        String str = "aliyuncs.com/";
        int beginIndex = fileUrl.indexOf(str);
        if (beginIndex == -1) {
            return null;
        }
        return fileUrl.substring(beginIndex + str.length());
    }

    /**
     * @param fileUrls 文件url
     * @return List<String>  fileName集合
     * @MethodName: getFileName
     * @Description: 根据url获取fileNames集合
     */
    private static List<String> getFileName(List<String> fileUrls) {
        List<String> names = new ArrayList<>();
        for (String url : fileUrls) {
            names.add(getFileName(url));
        }
        return names;
    }
}