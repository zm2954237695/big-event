package com.guo.event.mapper;


import com.guo.event.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    void add(Category category);
}
