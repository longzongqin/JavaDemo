package com.longzongqin.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


//标识为Bean
 @Component
//表明这是一个配置类
//@Configuration
//该注解用于绑定属性。prefix用来选择属性的前缀，也就是在remote.properties文件中的“remote”，ignoreUnknownFields是用来告诉SpringBoot在有属性不能匹配到声明的域时抛出异常。
@ConfigurationProperties(prefix = "customer", ignoreUnknownFields = false)
//@PropertySource("classpath:config.properties") //配置文件路径

public class ConfigProperties {
    private String uploadImagePath;
    private String uploadFilePath;

    public String getUploadImagePath() {
        return uploadImagePath;
    }

    public void setUploadImagePath(String uploadImagePath) {
        this.uploadImagePath = uploadImagePath;
    }

    public String getUploadFilePath() {
        return uploadFilePath;
    }

    public void setUploadFilePath(String uploadFilePath) {
        this.uploadFilePath = uploadFilePath;
    }
}

