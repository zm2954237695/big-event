package com.guo.event.controller;


import com.guo.event.pojo.Category;
import com.guo.event.pojo.Result;
import com.guo.event.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {



    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Result add(@RequestBody Category category) {
          categoryService.add(category);
          return Result.success();
    }
}