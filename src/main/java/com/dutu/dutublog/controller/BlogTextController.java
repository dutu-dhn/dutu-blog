package com.dutu.dutublog.controller;

import com.dutu.dutublog.bean.Blog;
import com.dutu.dutublog.bean.Bt;
import com.dutu.dutublog.service.BlogTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author dutu
 * @date 2021-03-26 21:14
 */
@Controller
public class BlogTextController {
    @Autowired
    BlogTextService blogTextService;

    /**
     * 查看blog
     * @return
     */
    @RequestMapping("/read/{btid}")
    public String showBt(@PathVariable("btid") Integer btid, Model model){
        Bt bt = blogTextService.getBtById(btid);
        model.addAttribute("bt",bt);
        Blog blog = blogTextService.getBlogTextById(btid);
        model.addAttribute("blog",blog);
        return "read";
    }

    /**
     * 去博客内容页面
     * @return
     */
    @RequestMapping("/article")
    public String toArticle(Model model){
        List<Blog> blogList = blogTextService.getBlogTextList();
        model.addAttribute("blogList",blogList);
        return "article";
    }
}
