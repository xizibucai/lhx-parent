package com.lhx.dm.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author hc
 * @version 1.0
 */

public interface ImageOssService  {
    //上传头像
    String upload(MultipartFile file);
}
