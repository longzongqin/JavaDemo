package com.longzongqin.demo.mapper;

import com.longzongqin.demo.entity.UserInfo;
import com.longzongqin.demo.service.UserInfoService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class UserInfoMapperTest {

    @Autowired
    private UserInfoService userInfoService;
    @Test
    public void getUserAndImg() throws Exception {

        List<UserInfo> userInfoList = userInfoService.getUserAndImg();
        List<Map> userInfoList2 = userInfoService.getUserAndImg2();
        System.out.println(userInfoList.toString());
        System.out.println("longzongqin");
    }

}