package com.longzongqin.demo.mapper;

import com.longzongqin.demo.entity.UserInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author longzongqin
 * @since 2018-03-17
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    List<UserInfo> getAll();

    List<UserInfo> getUserByName(String nick);

    List<UserInfo> getUserAndImg();

    List<Map> getUserAndImg2();

}
