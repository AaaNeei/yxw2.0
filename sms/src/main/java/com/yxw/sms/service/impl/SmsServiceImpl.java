package com.yxw.sms.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.yxw.sms.service.SmsService;
import com.yxw.sms.util.SendMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;


import java.util.concurrent.TimeUnit;

/**
 * @Author:阿倪
 * @Date: 2019/3/16 10:09
 * @Description:
 * @return:
 * @throws:
 */
@Service
public class SmsServiceImpl implements SmsService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Value("${yxw.sms.timeout}")
    private int timeout;
    @Value("${yxw.sms.Uid:AaNeei}")
    private String Uid;
    @Value("${yxw.sms.Key:d41d8cd98f00b204e980}")
    private String Key;
    @Value("${yxw.sms.project:游学网}")
    private String project;


    @Override
    public String sendMessage(String sendPhoneNum) {
        String code = SendMessageUtil.createRandomNum(6);
        //sendPhoneNum = "15606713936";
        Integer resultCode = SendMessageUtil.send(Uid, Key, sendPhoneNum, "尊敬的用户，您好，您正在注册" + project + "，您的验证码为：" + code + "，请于" + timeout + "分钟内正确输入，如非本人操作，请忽略此短信。");
        if (resultCode > 0) {
            //手机验证码发送成功。验证码存入Redis缓存
            redisTemplate.opsForValue().set("yxw_sms_code:" + sendPhoneNum, code);
            redisTemplate.expire("yxw_sms_code:" + sendPhoneNum, timeout, TimeUnit.MINUTES);
            System.out.println("已发送至：" + sendPhoneNum + "，验证码：" + redisTemplate.opsForValue().get("yxw_sms_code:" + sendPhoneNum));
            return "success";
        } else {
            String message = SendMessageUtil.getMessage(resultCode);
            return message;
        }


    }


}
