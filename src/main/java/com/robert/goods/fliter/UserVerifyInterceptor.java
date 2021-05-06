package com.robert.goods.fliter;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户验证拦截器
 * @Author robert
 * @Date 2021/3/10 17:27
 * @Version 1.0
 */
public class UserVerifyInterceptor extends HandlerInterceptorAdapter {

    // 忽略的URL地址
    private static final String[] IGNORE_URI = {"/login","/loginOut","/error"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("token");// 从 http 请求头中取出 token
        System.out.println("开始拦截了。。。。。。。。。");
        System.out.println("============"+token);
        try{
           // User user = (User)request.getSession().getAttribute(token);
            String requestURI = request.getRequestURI();
            String contextPath = request.getContextPath();
            contextPath = contextPath+"/";

            for (int i = 0; i < IGNORE_URI.length; i++) {
                // 忽略的url地址
                if (requestURI.contains(IGNORE_URI[i]) || requestURI.equals(contextPath)) {
                    System.out.println("忽略");
                    return true;

                }
            }
            //如果session为空则提示未登录
//            if( null == user) {
//                System.out.println("被拦截==========");
//               return false;
//            }
            System.out.println("通过了===========");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
