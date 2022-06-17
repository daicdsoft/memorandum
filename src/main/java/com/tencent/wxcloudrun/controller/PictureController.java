package com.tencent.wxcloudrun.controller;

import com.alibaba.fastjson.JSONObject;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.config.ResponseStatus;
import com.tencent.wxcloudrun.dao.SweetPictureInfoDao;
import com.tencent.wxcloudrun.dto.CounterRequest;
import com.tencent.wxcloudrun.entity.SweetPictureInfo;
import com.tencent.wxcloudrun.service.CounterService;
import com.tencent.wxcloudrun.service.PictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/picture")
public class PictureController {

    @Autowired
    private PictureService pictureService;


    final CounterService counterService;
    final Logger logger;

    public PictureController(@Autowired CounterService counterService) {
        this.counterService = counterService;
        this.logger = LoggerFactory.getLogger(CounterController.class);
    }
    /**
     * 上传图片
     * @param request {@link CounterRequest}
     * @return API response json
     */
    @PostMapping(value = "/upload")
    @ResponseStatus(code = "0")
    ApiResponse create(@RequestBody MultipartFile file, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        String user = (String)Optional.ofNullable(session.getAttribute("user")).orElse("");

        boolean isSuccess = pictureService.savePicture(file, user);
//        return object.toJSONString();

        return ApiResponse.ok();

    }


}
