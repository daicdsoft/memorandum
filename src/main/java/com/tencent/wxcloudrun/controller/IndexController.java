package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.IndexService;
import com.tencent.wxcloudrun.util.AesUtil;
import com.tencent.wxcloudrun.util.CryptoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * index控制器
 */
@Controller
@Slf4j
@RequestMapping
public class IndexController {

    @Autowired
    private IndexService indexService;

    /**
     * 主页页面
     *
     * @return API response html
     */
    @GetMapping()
    public String index() {
        log.info("index");
        return "index";
    }

    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 10; i++) {
            String memo = CryptoUtil.encryption("20220312");
            System.out.println(memo);
        }

    }
    @ResponseBody
    @PostMapping("/user/login")
    public ApiResponse login(@RequestBody User user, HttpServletRequest request) throws InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException {

        boolean flag = indexService.checkUser(user);

        if(flag){
            HttpSession session = request.getSession();
            session.setAttribute("user", user.getUsername());
            session.setMaxInactiveInterval(60 * 30);

            return ApiResponse.ok();
        }
        return ApiResponse.error("shibai");
    }

    @ResponseBody
    @PostMapping("/user/loginOut")
    public ApiResponse loginOut(HttpServletRequest request) throws InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException {
            log.info("login out");
            HttpSession session = request.getSession();
            session.removeAttribute("user");
            return ApiResponse.ok();

    }
}
