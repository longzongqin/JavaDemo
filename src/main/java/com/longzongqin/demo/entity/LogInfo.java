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
public class LogInfo extends Model<UserInfo>{


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String url;
    private String name;
    private String createTime;
    private String macAddress;
    private String ip;
    private String os;
    private String browser;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    @Override
    public String toString() {
        return "LogInfo{" +
        ", id=" + id +
        ", url=" + url +
        ", name=" + name +
        ", createTime=" + createTime +
        ", macAddress=" + macAddress +
        ", ip=" + ip +
        "}";
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
