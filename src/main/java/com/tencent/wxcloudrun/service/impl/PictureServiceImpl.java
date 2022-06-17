package com.tencent.wxcloudrun.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tencent.wxcloudrun.dao.SweetPictureInfoDao;
import com.tencent.wxcloudrun.entity.SweetPictureInfo;
import com.tencent.wxcloudrun.service.PictureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class PictureServiceImpl implements PictureService {

    @Autowired
    private SweetPictureInfoDao pictureInfoDao;


    @Override
    public boolean savePicture(MultipartFile file,String username) throws IOException {
        Date curDate = new Date();
        SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyyMMdd");
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String url = getUrl();

        // OaConstant.picDir.picloc 是本地保存图片的位置
        String picDir = url + ymdFormat.format(curDate);
        File picDirGsPic = new File(url);
        //判断存图片的文件夹是否存在，不存在则创建
        if(!picDirGsPic.exists()) {
            picDirGsPic.mkdir();
        }
        File picDirF = new File(picDir);
        //存图片的文件夹按日期一天生成一个，这里判断当天的是否已存在，不存在则创建
        if(!picDirF.exists()) {
            picDirF.mkdir();
        }

        //按日期生成保存图片的文件名
        String picPath = picDir+ File.separatorChar+ file.getOriginalFilename();
        FileOutputStream fout;
        try {
            fout = new FileOutputStream(picPath);
            fout.write(file.getBytes());
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        //把图片的保存路径转成Json传给前台
        SweetPictureInfo info = new SweetPictureInfo();
        info.setFileName(file.getName());
        info.setFilePath(picPath);
        info.setUserName(username);
        pictureInfoDao.insert(info);

        return true;
    }

    public String getUrl() throws IOException {

        String osName = System.getProperty("os.name");
        if(osName.startsWith("Windows")) {
            log.info("osname:windows");
            return "F:/java/code/";
        } else if(osName.startsWith("Linux")) {
            log.info("已检测到您当前使用的系统为：Linux");
            return "app/image/";
        }

        return "";
    }
}
