package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.CounterRequest;
import com.tencent.wxcloudrun.service.CounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/picture")
public class PictureController {


    final CounterService counterService;
    final Logger logger;

    public PictureController(@Autowired CounterService counterService) {
        this.counterService = counterService;
        this.logger = LoggerFactory.getLogger(CounterController.class);
    }
    /**
     * 更新计数，自增或者清零
     * @param request {@link CounterRequest}
     * @return API response json
     */
    @PostMapping(value = "/upload")
    ApiResponse create(@RequestBody MultipartFile file, HttpServletRequest request) {


        return ApiResponse.ok();

    }
}
