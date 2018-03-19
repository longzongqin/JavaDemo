package com.longzongqin.demo.service.impl;

import com.longzongqin.demo.config.ConfigProperties;
import com.longzongqin.demo.entity.ImgInfo;
import com.longzongqin.demo.mapper.ImgInfoMapper;
import com.longzongqin.demo.service.ImgInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.longzongqin.demo.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author longzongqin
 * @since 2018-03-19
 */
@Service
@EnableConfigurationProperties(ConfigProperties.class)
public class ImgInfoServiceImpl extends ServiceImpl<ImgInfoMapper, ImgInfo> implements ImgInfoService {

    @Autowired
    private ConfigProperties configProperties;

    @Override
    public boolean uploadImage(String[] base64Arr, String[] suffixArr) throws Exception {

        for (int i = 0; i < suffixArr.length; i++) {
            String url = ImageUtil.uploadBase64Image(base64Arr[i], suffixArr[i], configProperties.getUploadImagePath());
            System.out.println(base64Arr[i]);

            ImgInfo imgInfo = new ImgInfo();
            imgInfo.setUrl(url);
            imgInfo.insert();
            System.out.println(imgInfo.toString());

        }

        return true;
    }
}
