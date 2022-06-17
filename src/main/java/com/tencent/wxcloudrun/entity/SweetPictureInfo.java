package com.tencent.wxcloudrun.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (SweetPictureInfo)实体类
 *
 * @author makejava
 * @since 2022-06-16 15:33:14
 */
public class SweetPictureInfo implements Serializable {
    private static final long serialVersionUID = 809991319413926313L;
    
    private Integer id;
    
    private String fileName;
    
    private String filePath;
    
    private String userName;
    
    private Date createTime;
    
    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}

