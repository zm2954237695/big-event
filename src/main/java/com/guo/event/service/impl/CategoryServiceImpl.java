package com.guo.event.service.impl;

import com.guo.event.mapper.CategoryMapper;
import com.guo.event.pojo.Category;
import com.guo.event.service.CategoryService;
import com.guo.event.utils.CurrentUserUtil;
import com.guo.event.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void add(Category category) {
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        category.setCreateUser(CurrentUserUtil.getCurrentUser());
        categoryMapper.add(category);
    }

    @Override
    public List<Category> list() {
        return categoryMapper.list(CurrentUserUtil.getCurrentUser());
    }

    @Override
    public Category findById(Integer id) {
        return categoryMapper.findById(id);
    }

    @Override
    public void update(Category category) {
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.update(category);
    }
}
