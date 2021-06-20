package com.dutu.dutublog.service;

import com.dutu.dutublog.bean.Comment;

import java.util.List;

/**
 * @author dutu
 * @date 2021-05-28 16:37
 */
public interface CommentService {
    List<Comment> getAllMessage();
}
