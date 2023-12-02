package com.guo.event.interceptors;


import com.guo.event.utils.JwtUtil;
import com.guo.event.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        try {
            String redisToken = stringRedisTemplate.opsForValue().get(token);
            Map<String,Object> claims = JwtUtil.parseToken(token);
            if(redisToken==null){
                throw new RuntimeException();
            }
            ThreadLocalUtil.set(claims);
            return true;


        } catch (Exception e){
             response.setStatus(401);
             return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
           ThreadLocalUtil.remove();
    }
}
