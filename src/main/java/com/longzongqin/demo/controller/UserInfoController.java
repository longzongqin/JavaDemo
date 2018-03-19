package com.longzongqin.demo.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.longzongqin.demo.entity.UserInfo;
import com.longzongqin.demo.service.UserInfoService;
import com.longzongqin.demo.utils.JacksonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author longzongqin
 * @since 2018-03-19
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping
    public String index(ModelMap map){
        EntityWrapper<UserInfo> ew = new EntityWrapper<UserInfo>();
        ew.eq("status",0);
        ew.orderDesc(Arrays.asList("id"));
        Page<UserInfo> userInfo = userInfoService.selectPage(new Page<UserInfo>(0,20),ew);

        map.put("test","test info");
        map.put("userInfo", userInfo);
        return "userInfo/index";
    }
    @PostMapping("/addUser")
    @ResponseBody
    public String addUser(UserInfo userInfo){
        boolean result = false;
        if(userInfo.getId() == 0){
            result = userInfo.insert();
        }else{
            result = userInfo.updateById();
        }
        if(result){
            return JacksonUtil.ajaxReturn("","操作成功！",1);
        }else{
            return JacksonUtil.ajaxReturn("","操作失败！",0);
        }
    }
    @PostMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(UserInfo userInfo){
        userInfo.setStatus(1);
        boolean result = userInfo.updateById();
        if(result){
            return JacksonUtil.ajaxReturn("","操作成功！",1);
        }else{
            return JacksonUtil.ajaxReturn("","操作失败！",0);
        }
    }

}

