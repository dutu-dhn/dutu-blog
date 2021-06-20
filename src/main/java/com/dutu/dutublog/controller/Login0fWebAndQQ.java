package com.dutu.dutublog.controller;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.dutu.dutublog.bean.Userwb;
import com.dutu.dutublog.service.UserWBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;



/**
 * @author dutu
 * @date 2021-05-26 16:48
 */
@Controller
public class Login0fWebAndQQ {

    /** 微博第三方登录信息 */
    private static final String APP_KEY_WEIBO = "3452297360";
    private static final String APP_SECRECT_WEIBO = "c6ff3a16a3131f5378ed31f852d975b7";
    private static final String REDIRECT_URI_WEIBO = "http://dutu.cn.utools.club/webLogin";
    @Autowired
    UserWBService userWBService;

    @RequestMapping("/webLogin")
    @ResponseBody
    public String weiboLoginCallBack(HttpServletRequest request, HttpSession session) {
        // 返回参数
        Map<String, Object> rtnMap = new HashMap<>();
        // 1、用户登录成功后跳转到回调地址带的参数code
        String code = request.getParameter("code");
        String uri="https://api.weibo.com/oauth2/access_token";
        rtnMap.put("client_id",APP_KEY_WEIBO);
        rtnMap.put("client_secret",APP_SECRECT_WEIBO);
        rtnMap.put("grant_type","authorization_code");
        rtnMap.put("redirect_uri",REDIRECT_URI_WEIBO);
        rtnMap.put("code",code);
        String post = HttpUtil.post(uri, rtnMap);
        Map<String,String> parse = (Map<String, String>) JSON.parse(post);
        String access_token=parse.get("access_token");
        String uid=parse.get("uid");
        String s = HttpUtil.get("https://api.weibo.com/2/users/show.json?access_token=" + access_token + "&uid=" + uid);
        Map<String, String> user = (Map<String, String>) JSON.parse(s);
        session.setAttribute("user",user);

        Userwb userWB = new Userwb();
        userWB.setIdstr(user.get("idstr"));
        userWB.setScreenname(user.get("screen_name"));
        userWBService.loginUserofWB(userWB);

        // 待改
        String html = "<script language='javaScript' type='text/javaScript'>window.open('http://dutu.cn.utools.club/article.html','article');"+"window.close();</script>";

        return html;
        //return "redirect:/index.html";
    }

    @GetMapping("/logout")
    @ResponseBody
    public String logOut(HttpSession session){
        session.removeAttribute("user");
        return "SUCCESS";
    }
}
