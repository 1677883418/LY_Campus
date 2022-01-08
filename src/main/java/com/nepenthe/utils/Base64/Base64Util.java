package com.nepenthe.utils.Base64;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * <p>description goes here</p>
 *
 * @author 冷澳
 * @date 2021/12/26
 */
public class Base64Util {
    /**
     * base64转MultipartFile
     */
    public static MultipartFile base64ToMultipart(String base64) {
        String format = checkImageBase64Format(base64);

        String temp = "data:image/" + format;
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = new byte[0];
        bytes = decoder.decode(base64);
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] < 0) {
                bytes[i] += 256;
            }
        }
        return Base64Decoder.multipartFile(bytes, temp);
    }

    public static File base64ToFile(String base64) {
        String format = "." + checkImageBase64Format(base64);

        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            //创建文件目录
            file = File.createTempFile("temp", format);
            file.deleteOnExit();
            byte[] bytes = Base64.getDecoder().decode(base64);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }

    /**
     * 判断图片base64字符串的文件格式
     *
     * @param base64ImgData
     * @return
     */
    public static String checkImageBase64Format(String base64ImgData) {
        byte[] b = Base64.getDecoder().decode(base64ImgData);
        String type = "";
        if (0x424D == ((b[0] & 0xff) << 8 | (b[1] & 0xff))) {
            type = "bmp";
        } else if (0x8950 == ((b[0] & 0xff) << 8 | (b[1] & 0xff))) {
            type = "png";
        } else if (0xFFD8 == ((b[0] & 0xff) << 8 | (b[1] & 0xff))) {
            type = "jpg";
        }
        return type;
    }
}
