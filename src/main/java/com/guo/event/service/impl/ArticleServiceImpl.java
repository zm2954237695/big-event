package com.guo.event.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guo.event.mapper.ArticleMapper;
import com.guo.event.pojo.Article;
import com.guo.event.pojo.PageBean;
import com.guo.event.service.ArticleService;
import com.guo.event.utils.CurrentUserUtil;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {



    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
          article.setCreateTime(LocalDateTime.now());
          article.setUpdateTime(LocalDateTime.now());
          article.setCreateUser(CurrentUserUtil.getCurrentUser());
          articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        PageBean<Article> pb = new PageBean<>();
        PageHelper.startPage(pageNum,pageSize);
        List<Article> as  = articleMapper.list(categoryId,state,CurrentUserUtil.getCurrentUser());
        Page<Article> p = (Page<Article>) as;
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }
}
