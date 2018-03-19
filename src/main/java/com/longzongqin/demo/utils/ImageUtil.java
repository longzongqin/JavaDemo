package com.longzongqin.demo.utils;


import ch.qos.logback.core.util.FileUtil;
import org.apache.tomcat.jni.Global;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.util.Base64Utils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class ImageUtil {


    public static String uploadBase64Image(String base64Data, String suffix, String path) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
        String month = sdf.format(new Date());
        String pathRoot = System.getProperty("user.dir");
        String fileName = path + month + "/" + UUID.randomUUID() + "." + suffix;
        String filePath = pathRoot + fileName;

        File file = new File(filePath);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }

        String data = "";
        String [] d = base64Data.split("base64,");
        if(d != null && d.length == 2){
            data = d[1];
        }else{
            throw new Exception("上传失败，数据不合法");
        }

        //因为BASE64Decoder的jar问题，此处使用spring框架提供的工具包
        byte[] bs = Base64Utils.decodeFromString(data);
        try{
            OutputStream out = new FileOutputStream(filePath);
            out.write(bs);
            out.flush();
            out.close();
        }catch(Exception ee){
            throw new Exception("上传失败，写入文件失败，"+ee.getMessage());
        }
        return fileName;
    }


}

