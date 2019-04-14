package com.yxw.web.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

/**
 * @Author:阿倪
 * @Date: 2019/3/8 10:29
 * @Description:
 * @return:
 * @throws:
 */
@Service
public class JMSProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    // 发送消息，destination是发送到的队列，message是待发送的消息
    public void sendMessage(Destination destination, final String message){
        jmsTemplate.convertAndSend(destination, message);
    }


}
