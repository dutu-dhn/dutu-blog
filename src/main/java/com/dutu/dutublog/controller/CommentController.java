package com.dutu.dutublog.controller;

import com.dutu.dutublog.Util.Myutil;
import com.dutu.dutublog.bean.Comment;
import com.dutu.dutublog.bean.Userwb;
import com.dutu.dutublog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author dutu
 * @date 2021-05-28 16:38
 */
@Controller
public class CommentController {
    @Autowired
    CommentService commentService;
    @GetMapping("/message.html")
    public String tomessage(){
       // commentService.getAllMessage();
        return "message";
    }

    @RequestMapping(value = "/message/add",method = RequestMethod.GET)
    public String addMessage(@RequestParam String editorContent, HttpSession session){
        // 判断是否登录,未登录无法留言
        Map<String, String> user = (Map) session.getAttribute("user");
        if (user == null){
            return "redirect:/index.html";
        }
        // 发送者id
        Comment comment = new Comment();
        comment.setUserId(user.get("idstr"));
        comment.setContent(editorContent);
        comment.setDate(Myutil.getDate());

        System.out.println(editorContent);
        return "redirect:/message.html";
    }

}
