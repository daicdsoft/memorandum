package com.tencent.wxcloudrun.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface PictureService {
    boolean savePicture(MultipartFile file, String username) throws IOException;
}
