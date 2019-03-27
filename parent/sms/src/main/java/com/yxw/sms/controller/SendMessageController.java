package com.yxw.sms.controller;/*
package com.yxw.sms.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.yxw.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

*/
/**
 * @Author:阿倪
 * @Date: 2019/3/16 10:08
 * @Description:
 * @return:
 * @throws:
 *//*

@Controller
@RequestMapping("/yxw")
public class SendMessageController {

    @Reference
    private SmsService smsService;

    @RequestMapping("/sendMessage")
    public String sendMessage(String sendPhoneNum) {
        String message = smsService.sendMessage(sendPhoneNum);
        return message;
    }


}
*/
