package com.dutu.dutublog.service;

import com.dutu.dutublog.bean.Blable;
import com.dutu.dutublog.bean.Blog;
import com.dutu.dutublog.bean.Bt;

import java.sql.Blob;
import java.util.List;

/**
 * @author dutu
 * @date 2021-03-26 21:15
 */
public interface BlogTextService {
    Bt getBtById(int i);

    List<Blog> getBlogTextList();

    Blog getBlogTextById(Integer btid);

    List<Blog> getBlogByBrowse(Integer limit);

    List<Blable> getBlogLable();

    List<Blog> getBlogLableList(Integer blid);

    int updBrowse(Blog blog);
}
