package com.yxw.sms.service;


/**
 * @Author:阿倪
 * @Date: 2019/3/17 19:07
 * @Description: 短信接口
 * @return:
 * @throws:
 */
public interface SmsService {
    //发送短信
    public String sendMessage(String sendPhoneNum);

}
