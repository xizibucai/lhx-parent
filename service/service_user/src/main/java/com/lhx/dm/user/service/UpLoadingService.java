package com.lhx.dm.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lhx.db.result.R;
import com.lhx.dm.user.entity.User;
import com.lhx.dm.user.vo.uploadVo.UserUploadingVo;

/**
 * @author hc
 * @version 1.0
 */
public interface UpLoadingService extends IService<User> {
    R userGetGallery(String id);
}
