package com.longzongqin.demo.mapper;

import com.longzongqin.demo.entity.ImgInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author longzongqin
 * @since 2018-03-19
 */
public interface ImgInfoMapper extends BaseMapper<ImgInfo> {
    public List<ImgInfo> getImgInfoByUser(int user_info_id);
}
