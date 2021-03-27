package com.dutu.dutublog.controller;

import com.dutu.dutublog.bean.Admin;
import com.dutu.dutublog.bean.Bt;
import com.dutu.dutublog.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author dutu
 * @date 2021-03-25 10:50
 */
@Slf4j
@Controller
public class AdminController {
    @Autowired
    AdminService adminService;

    /**
     * 开局拿到admin的用户数据
     * @return
     */
    @GetMapping("/")
    public String getAdminMessage(Model model, HttpSession session){
        Admin adminMessage = adminService.getAdminMessage();
        // 把拿到的admin放到model中
       // model.addAttribute("adminMessage",adminMessage);
        session.setAttribute("adminMessage",adminMessage);
        return "index";
    }



    @GetMapping("/Edit")
    public String toEdit(){
        return "textpostmarkdown";
    }


    @PostMapping("/savebt")
    public String saveBt(Bt bt){


        return "textpostmarkdown";
    }



}
