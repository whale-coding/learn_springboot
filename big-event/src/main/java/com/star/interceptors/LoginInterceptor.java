package com.star.interceptors;

import com.star.utils.JwtUtil;
import com.star.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * @Classname: LoginInterceptor
 * @Date: 2024/11/27 20:25
 * @Author: 聂建强
 * @Description: 登录拦截器
 */
@Component  // 将拦截器加入到Spring容器里面
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 重写请求到达之前的拦截方法，会在请求到达接口之前执行
     * @param request 请求头
     * @param response 响应头
     * @param handler 处理器
     * @return 是否放行
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求头中的token
        String token = request.getHeader("Authorization");
        // token验证
        try {
            // 从redis中获取相同的token
            String redisToken = stringRedisTemplate.opsForValue().get(token);
            if (redisToken==null){
                // token已经失效，抛出异常之后会走到catch块中，不放行
                throw new RuntimeException();
            }
            Map<String, Object> claims = JwtUtil.parseToken(token);
            // 如果可以解析token不抛出异常，放行

            // 将载荷claims即业务数据存储到ThreadLocal中，减少参数的传递
            ThreadLocalUtil.set(claims);

            // 放行
            return true;
        }catch (Exception e){
            // 捕获异常，说明token验证失败
            response.setStatus(401);  // http响应状态码设置为401
            // 不放行
            return false;
        }
    }

    // 重写请结束之后的拦截方法，会在请求接口之后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 清空ThreadLocal中的数据，防止内存泄露
        ThreadLocalUtil.remove();
    }
}
