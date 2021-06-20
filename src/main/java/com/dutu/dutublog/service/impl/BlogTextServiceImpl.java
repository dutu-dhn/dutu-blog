package com.dutu.dutublog.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dutu.dutublog.bean.Blable;
import com.dutu.dutublog.bean.Blog;
import com.dutu.dutublog.bean.Bt;
import com.dutu.dutublog.mapper.BlableMapper;
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
    @Autowired
    BlableMapper blableMapper;


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

    @Override
    public List<Blog> getBlogByBrowse(Integer limit) {

        QueryWrapper<Blog> wrapper = Wrappers.query();
        wrapper.orderByDesc("browse").last("limit 6");
        List<Blog> blogList = blogMapper.selectList(wrapper);
        return blogList;
    }

    @Override
    public List<Blable> getBlogLable() {
        List<Blable> blableList = blableMapper.selectList(null);
        return blableList;
    }

    @Override
    public List<Blog> getBlogLableList(Integer blid) {
        QueryWrapper<Blog> wrapper = Wrappers.query();
        wrapper.eq("lableid",blid);
        List<Blog> blogList = blogMapper.selectList(wrapper);
        return blogList;
    }

    @Override
    public int updBrowse(Blog blog) {
        QueryWrapper<Blog> wrapper = Wrappers.query();
        wrapper.eq("bid",blog.getBid());
        blogMapper.update(blog,wrapper);
        return blogMapper.updateById(blog);
    }
}
