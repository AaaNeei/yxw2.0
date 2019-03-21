package com.yxw.web.service.impl;

import com.yxw.web.entity.MobileCode;
import com.yxw.web.mapper.SmsMapper;
import com.yxw.web.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author:阿倪
 * @Date: 2019/3/17 22:11
 * @Description:
 * @return:
 * @throws:
 */
@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private SmsMapper smsMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String sendMessageDev(String stuMobile) {
        MobileCode mobileCode = new MobileCode();
        String code = createRandomNum(6);
        mobileCode.setCode(code);
        mobileCode.setMobile(stuMobile);
        Integer resultCode = smsMapper.sendMessageDev(mobileCode);
        if (resultCode > 0) {
            //手机验证码发送成功。验证码存入Redis缓存
            redisTemplate.opsForValue().set("yxw_sms_code_dev:" + stuMobile, code);
            redisTemplate.expire("yxw_sms_code_dev:" + stuMobile, 10, TimeUnit.MINUTES);
            System.out.println("已发送至：" + stuMobile + "，验证码：" + redisTemplate.opsForValue().get("yxw_sms_code_dev:" + stuMobile));
            return "1";
        }
        return "0";

    }

    public static String createRandomNum(int num) {
        String randomNumStr = "";
        for (int i = 0; i < num; i++) {
            int randomNum = (int) (Math.random() * 10);
            randomNumStr += randomNum;
        }
        return randomNumStr;
    }
}
