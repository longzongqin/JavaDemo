package com.longzongqin.demo.service;

import com.longzongqin.demo.entity.ImgInfo;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author longzongqin
 * @since 2018-03-19
 */
public interface ImgInfoService extends IService<ImgInfo> {
    boolean uploadImage(String[] base64Arr, String[] suffixArr) throws Exception;
}
