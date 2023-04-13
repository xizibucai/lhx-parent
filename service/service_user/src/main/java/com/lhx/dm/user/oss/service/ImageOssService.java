package com.lhx.dm.user.oss.service;

import com.lhx.db.result.R;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hc
 * @version 1.0
 */

public interface ImageOssService  {
    //上传头像
    String upload(MultipartFile file);

    R ossImageDel(Long id);

    R osssImageDel(String url);
}
