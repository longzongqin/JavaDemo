package com.longzongqin.demo;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.longzongqin.demo.utils.MyTimeUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


/**
 *  注入公共字段自动填充,任选注入方式即可
 */
//@Component
public class MyMetaObjectHandler extends MetaObjectHandler {

    protected final static Logger logger = LoggerFactory.getLogger(Application.class);

    @Override
    public void insertFill(MetaObject metaObject) {
        logger.info("新增的时候干点不可描述的事情");
        Object createTime = getFieldValByName("createTime", metaObject);
        Object updateTime = getFieldValByName("updateTime", metaObject);
        System.out.println(MyTimeUtil.getNowDateTime());
        if(createTime == null){
            setFieldValByName("createTime", MyTimeUtil.getNowDateTime(), metaObject);
        }
        if(updateTime == null){
            setFieldValByName("updateTime", MyTimeUtil.getNowDateTime(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        logger.info("更新的时候干点不可描述的事情");
        Object updateTime = getFieldValByName("updateTime", metaObject);
        if(updateTime == null){
            setFieldValByName("updateTime", MyTimeUtil.getNowDateTime(), metaObject);
        }
    }

}
