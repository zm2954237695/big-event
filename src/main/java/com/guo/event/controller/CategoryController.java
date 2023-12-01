package com.guo.event.controller;


import com.guo.event.pojo.Category;
import com.guo.event.pojo.Result;
import com.guo.event.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {



    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Result add(@RequestBody @Validated(Category.Add.class) Category category) {
          categoryService.add(category);
          return Result.success();
    }

    @GetMapping
    public Result<List<Category>> list() {
        List<Category> cs = categoryService.list();
        return Result.success(cs);
    }

    @GetMapping("/detail")
    public Result<Category> detail(Integer id) {
        return Result.success(categoryService.findById(id));
    }


    @PutMapping
    public Result update(@RequestBody @Validated(Category.Update.class) Category category) {
         categoryService.update(category);
         return Result.success();
    }


}
