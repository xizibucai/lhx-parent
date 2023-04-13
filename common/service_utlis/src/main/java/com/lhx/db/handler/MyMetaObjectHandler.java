package com.lhx.db.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author hc
 * @version 1.0
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("joinDate", new Date(), metaObject);
        this.setFieldValByName("faceImg","http://lanhuanxi.oss-cn-hangzhou.aliyuncs.com/2022-11-16/285bb85c7a4e4444835a81805a93cddb999619.jpg",metaObject);
        this.setFieldValByName("url","http://lanhuanxi.oss-cn-hangzhou.aliyuncs.com/2022-11-16/285bb85c7a4e4444835a81805a93cddb999619.jpg",metaObject);
    }


    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);

    }
}
