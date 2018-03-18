package com.longzongqin.demo.service.impl;

import com.longzongqin.demo.entity.UserInfo;
import com.longzongqin.demo.mapper.UserInfoMapper;
import com.longzongqin.demo.service.UserInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author longzongqin
 * @since 2018-03-17
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Override
    public List<UserInfo> getAll() {
        return baseMapper.getAll();
    }

    @Override
    public List<UserInfo> getUserByName(String nick) {
        return baseMapper.getUserByName(nick);
    }
}
