package com.tencent.wxcloudrun.entity;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2022-06-16 15:32:43
 */
public class Admin implements Serializable {
    private static final long serialVersionUID = 233455943223909821L;
    
    private Integer id;
    
    private String name;
    
    private String pwd;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}

