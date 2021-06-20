package com.dutu.dutublog.controller;

import com.dutu.dutublog.bean.Blable;
import com.dutu.dutublog.bean.Blog;
import com.dutu.dutublog.bean.Bt;
import com.dutu.dutublog.service.BlogTextService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * @author dutu
 * @date 2021-03-26 21:14
 */
@Slf4j
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

        String browseStr = blog.getBrowse();
        int browse = Integer.valueOf(browseStr)+1;

        blog.setBrowse(browse+"");

        blogTextService.updBrowse(blog);

        model.addAttribute("blog",blog);
        return "read";
    }

    /**
     * 去博客内容页面
     * @return
     */
    @RequestMapping("/article.html")
    public String toArticle(Model model,HttpServletRequest request) {

        // 文章列表,默认排序
        List<Blog> blogList = blogTextService.getBlogTextList();

        model.addAttribute("blogList", blogList);


        // 热门文章,根据浏览人数排序
        List<Blog> blogByBrowse = blogTextService.getBlogByBrowse(6);

        // 标签分类
        List<Blable> blogLable = blogTextService.getBlogLable();


        model.addAttribute("requestURI" , request.getRequestURI());

        model.addAttribute("blogByBrowse", blogByBrowse);
        model.addAttribute("blogLable", blogLable);

        return "article";
    }

    /**
     * 去博客内容页面(根据标签)
     * @return
     */
    @RequestMapping("/article.html/{blid}")
    public String toArticleByBlId(@PathVariable("blid") Integer blid, Model model,HttpServletRequest request) {

        // 文章列表,按标签取到的
        List<Blog> blogList = blogTextService.getBlogLableList(blid);

        model.addAttribute("blogList", blogList);


        // 热门文章,根据浏览人数排序
        List<Blog> blogByBrowse = blogTextService.getBlogByBrowse(6);

        // 标签分类
        List<Blable> blogLable = blogTextService.getBlogLable();

        model.addAttribute("requestURI" , request.getRequestURI());
        model.addAttribute("blogByBrowse", blogByBrowse);
        model.addAttribute("blogLable", blogLable);

        return "article";
    }

    @GetMapping("/article/search")
    public String searchArticle(@RequestBody String searchText ){
        System.out.println("1234567890111111"+searchText);
        return "index";
    }

}
