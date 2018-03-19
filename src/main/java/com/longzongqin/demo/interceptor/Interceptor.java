package com.longzongqin.demo.interceptor;

import com.longzongqin.demo.entity.LogInfo;
import com.longzongqin.demo.utils.LocalUtil;
import com.longzongqin.demo.utils.SystemUtil;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Interceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Interceptor pre");


        String url = request.getContextPath()+request.getRequestURI();
        if(url.indexOf("static") == -1){
            String ip = LocalUtil.getIPAddress(request);
            String os = SystemUtil.getRequestSystemInfo(request);
            String browser = SystemUtil.getRequestBrowserInfo(request);

            LogInfo log = new LogInfo();
            log.setIp(ip);
            log.setUrl(url);
            log.setOs(os);
            log.setBrowser(browser);
            log.insert();
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("afterCompletion----------------------------------------------------");
    }

}
