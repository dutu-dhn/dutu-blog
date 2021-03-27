package com.dutu.dutublog.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dutu.dutublog.bean.Blog;
import com.dutu.dutublog.bean.Bt;
import com.dutu.dutublog.mapper.BlogMapper;
import com.dutu.dutublog.mapper.BtMapper;
import com.dutu.dutublog.service.BlogTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dutu
 * @date 2021-03-26 21:16
 */
@Service
public class BlogTextServiceImpl implements BlogTextService {
    @Autowired
    BtMapper btMapper;
    @Autowired
    BlogMapper blogMapper;


    @Override
    public Bt getBtById(int i) {
        return btMapper.selectById(i);
    }

    @Override
    public List<Blog> getBlogTextList() {
        List<Blog> blogs = blogMapper.selectList(null);
        return blogs;
    }

    @Override
    public Blog getBlogTextById(Integer btid) {
        return blogMapper.selectById(btid);
    }
}
