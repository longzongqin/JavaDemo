package com.longzongqin.demo.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author longzongqin
 * @since 2018-03-19
 */
public class ImgInfo extends Model<ImgInfo> {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String url;
    private String createTime;
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ImgInfo{" +
        ", id=" + id +
        ", url=" + url +
        ", createTime=" + createTime +
        ", status=" + status +
        "}";
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
