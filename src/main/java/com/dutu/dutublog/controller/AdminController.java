package com.dutu.dutublog.controller;

import com.dutu.dutublog.bean.Admin;
import com.dutu.dutublog.bean.Blog;
import com.dutu.dutublog.bean.Bt;
import com.dutu.dutublog.service.AdminService;
import com.dutu.dutublog.service.BlogTextService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author dutu
 * @date 2021-03-25 10:50
 */
@Slf4j
@Controller
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    BlogTextService blogTextService;

    /**
     * 开局拿到admin的用户数据
     * @return
     */
    @GetMapping("/index.html")
    public String getAdminMessage(Model model, HttpSession session){
        Admin adminMessage = adminService.getAdminMessage();
        // 把拿到的admin放到model中
       // model.addAttribute("adminMessage",adminMessage);
        session.setAttribute("adminMessage",adminMessage);

        List<Blog> blogByBrowse = blogTextService.getBlogByBrowse(3);
        model.addAttribute("blogByBrowse",blogByBrowse);


        return "index";
    }

    @GetMapping("/")
    public String toIndex(){
        return "redirect:/index.html";
    }





    @GetMapping("/link.html")
    public String tolink(){

        return "link";
    }

}
