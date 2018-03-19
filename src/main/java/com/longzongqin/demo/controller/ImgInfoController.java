package com.longzongqin.demo.controller;


import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.longzongqin.demo.config.ConfigProperties;
import com.longzongqin.demo.entity.ImgInfo;
import com.longzongqin.demo.entity.UserInfo;
import com.longzongqin.demo.service.ImgInfoService;
import com.longzongqin.demo.utils.ImageUtil;
import com.longzongqin.demo.utils.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author longzongqin
 * @since 2018-03-19
 */
@Controller
@RequestMapping("/imgInfo")
public class ImgInfoController {

    @Autowired
    private ImgInfoService imgInfoService;

    @GetMapping
    public String index(ModelMap map){
        EntityWrapper<ImgInfo> ew = new EntityWrapper<ImgInfo>();
        ew.eq("status",0);
        ew.orderDesc(Arrays.asList("id"));
        Page<ImgInfo> imgInfo = imgInfoService.selectPage(new Page<ImgInfo>(0,20),ew);
        map.put("imgInfo", imgInfo);
        return "imgInfo/index";
    }
    @PostMapping("/uploadImg")
    @ResponseBody
    public String uploadImg(HttpServletRequest request) throws Exception {
        String[] base64Arr = request.getParameterValues("base64Arr[]");
        String[] suffixArr = request.getParameterValues("suffixArr[]");
        boolean result = imgInfoService.uploadImage(base64Arr,suffixArr);
        if(result){
            return JacksonUtil.ajaxReturn("","操作成功！",1);
        }else{
            return JacksonUtil.ajaxReturn("","操作失败！",0);
        }
    }

    @PostMapping("/deleteImg")
    @ResponseBody
    public String deleteImg(ImgInfo imgInfo){
        imgInfo.setStatus(1);
        boolean result = imgInfo.updateById();
        if(result){
            return JacksonUtil.ajaxReturn("","操作成功！",1);
        }else{
            return JacksonUtil.ajaxReturn("","操作失败！",0);
        }
    }

}

