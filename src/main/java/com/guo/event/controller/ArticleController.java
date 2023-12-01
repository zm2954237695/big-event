package com.guo.event.controller;


import com.guo.event.pojo.Article;
import com.guo.event.pojo.PageBean;
import com.guo.event.pojo.Result;
import com.guo.event.service.ArticleService;
import com.guo.event.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {



    @Autowired
    private ArticleService articleService;

//       @GetMapping("/list")
//       public Result<String> list(@RequestHeader(name="Authorization")
//                                  String token, HttpServletResponse response) {
//           try{
//
//               Map<String,Object> claims = JwtUtil.parseToken(token);
//               return Result.success("所有文章..");
//           } catch (Exception e){
//               response.setStatus(401);
//               return Result.error("未登录");
//           }
//       }


    @PostMapping
     public Result add(@RequestBody @Validated  Article article) {
         articleService.add(article);
         return Result.success();
     }

     @GetMapping
     public Result<PageBean<Article>> list(Integer pageNum,
                                           Integer pageSize,
                                           @RequestParam(required = false) Integer categoryId,
                                           @RequestParam(required = false) String state) {
        return Result.success(articleService.list(pageNum,pageSize,categoryId,state));
     }
}
