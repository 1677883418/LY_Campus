import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;

public class Test {

    @Value("${oos.file.endpoint}")
    private static String endpoint;
    @Value("${oos.file.keyId}")
    private static String keyId;
    @Value("${oos.file.keySecret}")
    private static String keySecret;
    @Value("${oos.file.bucketName}")
    private static String bucketName;
    @Value("${oos.file.fileHost}")
    private static String fileHost;

    @org.junit.jupiter.api.Test
    public String upload() {
        File file = new File("E:\\IdeaProjects\\LY_Campus\\src\\main\\resources\\tmp.txt");
        //文件新路径
        OSS ossClient = null;
        try {
//            String fileName = file.getName();
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            String dateStr = format.format(new Date());
             ossClient = new OSSClientBuilder().build(endpoint, keyId, keySecret);
            System.out.println(ossClient);
            //创建文件路径
//            String fileUrl = fileHost + "/" + (dateStr + "/" + UUID.randomUUID().toString().replace("-", "") + "-" + file.getName());
            // 上传到阿里云
            PutObjectResult result = ossClient.putObject(bucketName, "fileUrl", file);
            System.out.println(result);
            if (null != result) {
//                return fileUrl;
                return null;
            }
        } catch (OSSException | ClientException oe) {

        } finally {
            //关闭
            ossClient.shutdown();
        }
        return null;
    }
}
