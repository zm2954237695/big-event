package com.guo.event.service;

import com.guo.event.pojo.Article;
import com.guo.event.pojo.PageBean;

public interface ArticleService {
    void add(Article article);

    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
