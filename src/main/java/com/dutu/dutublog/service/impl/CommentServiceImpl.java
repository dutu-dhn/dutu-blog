package com.dutu.dutublog.service.impl;

import com.dutu.dutublog.bean.Comment;
import com.dutu.dutublog.mapper.CommentMapper;
import com.dutu.dutublog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dutu
 * @date 2021-05-28 16:38
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> getAllMessage() {
        return commentMapper.selectList(null);
    }
}
