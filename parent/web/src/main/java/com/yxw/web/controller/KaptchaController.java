package com.yxw.web.controller;

import javax.servlet.http.HttpServletRequest;

import com.google.code.kaptcha.Constants;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KaptchaController {
    private static final transient Logger log = Logger.getLogger(KaptchaController.class);
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @param request
     * @param kaptchaReceived
     * @return String
     * @Title: loginCheck
     * @Description: 验证码校验
     */
    @RequestMapping(value = "/kaptcha", method = RequestMethod.POST)
    @ResponseBody
    public String loginCheck(HttpServletRequest request,
                             @RequestParam(value = "kaptcha", required = true) String kaptchaReceived) {
        //session中存取的验证码,后期改用缓存
        String kaptchaExpected = (String) redisTemplate.opsForValue().get(Constants.KAPTCHA_SESSION_KEY);

        /*String kaptchaExpected = (String) request.getSession().getAttribute(
                com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);*/

        //校验验证码是否正确
        if (kaptchaReceived == null || !kaptchaReceived.equals(kaptchaExpected)) {
            log.info("验证码错了");
            //返回验证码错误
            return "kaptcha_error";
        }
        //校验用户名密码
        // ……
        // ……
        log.info("验证码对了");
        //校验通过返回成功
        return "success";
    }


}
