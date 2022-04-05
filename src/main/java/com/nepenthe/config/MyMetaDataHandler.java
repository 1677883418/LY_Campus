package com.nepenthe.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyMetaDataHandler implements MetaObjectHandler {
    @Override
    /*插入时自动填充*/
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "dynamicTime", LocalDateTime::now, LocalDateTime.class);
        this.strictInsertFill(metaObject, "uploadTime", LocalDateTime::now, LocalDateTime.class);
    }

    @Override
    /*更新时自动填充*/
    public void updateFill(MetaObject metaObject) {

    }
}
