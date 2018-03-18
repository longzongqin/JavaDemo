package com.longzongqin.demo.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.longzongqin.demo.entity.UserInfo;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author longzongqin
 * @since 2018-03-17
 */
public interface UserInfoService extends IService<UserInfo> {
    List<UserInfo> getAll();

    List<UserInfo> getUserByName(String nick);
}
