package com.yxw.web.utils.cookie;

import org.apache.http.HttpResponse;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author:阿倪
 * @Date: 2019/3/24 21:04
 * @Description:
 * @return:
 * @throws:
 */
public class CookieUtils {

    public static void addCookie(HttpServletResponse response, String cookieName, String cookieValue) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        //
        cookie.setHttpOnly(true);
        //有效期一周
        cookie.setMaxAge(60 * 60 * 24 * 7);

        response.addCookie(cookie);
    }

    public static Cookie getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (StringUtils.pathEquals(cookie.getName(), cookieName)) {
                return cookie;
            }
        }
        return null;
    }

    public static void delCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        //
        cookie.setHttpOnly(true);
        //有效期一周
        cookie.setMaxAge(0);

        response.addCookie(cookie);
    }

}
