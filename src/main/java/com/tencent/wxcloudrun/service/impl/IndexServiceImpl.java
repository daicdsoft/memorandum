package com.tencent.wxcloudrun.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tencent.wxcloudrun.dao.AdminDao;
import com.tencent.wxcloudrun.entity.Admin;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.IndexService;
import com.tencent.wxcloudrun.util.CryptoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class IndexServiceImpl implements IndexService {

    @Resource
    private AdminDao adminDao;


    @Override
    public boolean checkUser(User user) {
        Admin admin = adminDao.queryByName(user.getUsername());
        log.info("user:{}", JSONObject.toJSONString(user));
        if(admin == null) {
            return false;
        }
        return CryptoUtil.decryption(admin.getPwd()).equals(CryptoUtil.decryption(user.getPassword()));
    }
}
