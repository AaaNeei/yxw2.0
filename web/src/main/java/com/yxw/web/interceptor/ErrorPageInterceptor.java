package com.yxw.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:阿倪
 * @Date: 2019/3/23 15:45
 * @Description:
 * @return:
 * @throws:
 */
@Component
public class ErrorPageInterceptor extends HandlerInterceptorAdapter {
    private List<Integer> errorCodeList = Arrays.asList(404, 403, 500, 501);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
            Exception {
        if (errorCodeList.contains(response.getStatus())) {
            response.sendRedirect("/error/" + response.getStatus());
            return false;
        }
        return super.preHandle(request, response, handler);
    }
}
