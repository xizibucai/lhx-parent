package com.lhx.dm.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.lhx.dm.oss.service.ImageOssService;
import com.lhx.dm.oss.utils.ConstantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author hc
 * @version 1.0
 */
@Service
public class ImageOssServiceImpl  implements ImageOssService {
    //上传头像
    @Override
    public String upload(MultipartFile file) {
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = ConstantPropertiesUtils.END_POINT;
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
        // 填写Bucket名称，例如examplebucket。
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;

        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
        String objectName = "exampledir/exampleobject.txt";
        // 填写本地文件的完整路径，例如D:\\localpath\\examplefile.txt。
        // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        // String filePath= "D:\\localpath\\examplefile.txt";

        //获取文件名称
        String filename = file.getOriginalFilename();
        //在文件名称里面添加随机唯一的值
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //构建日期路径：avatar/2019/02/26/文件名
        String filePath = new DateTime().toString("yyyy-MM-dd");

        //拼接上传到OSS的路径和名称
        filename = filePath + "/" + uuid + filename;
        String url = null;
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            //获取上传输入流
            InputStream inputStream = file.getInputStream();
            // 创建PutObject请求。
            /**  第一个参数：Bucket名称
             *  第二个参数：上传到OSS的路径和名称 /aa/bb/1.jpg
             *  第三个参数：上传输入流
             */
            ossClient.putObject(bucketName, filename, inputStream);
            //拼接图片地址
            url =  "http://" + bucketName + "." + endpoint + "/" + filename;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (IOException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return url;
    }
}
