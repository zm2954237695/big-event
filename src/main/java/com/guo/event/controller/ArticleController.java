package com.guo.event.controller;


import com.guo.event.pojo.Result;
import com.guo.event.utils.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {



       @GetMapping("/list")
       public Result<String> list(@RequestHeader(name="Authorization")
                                  String token, HttpServletResponse response) {
           try{

               Map<String,Object> claims = JwtUtil.parseToken(token);
               return Result.success("所有文章..");
           } catch (Exception e){
               response.setStatus(401);
               return Result.error("未登录");
           }
       }
}
