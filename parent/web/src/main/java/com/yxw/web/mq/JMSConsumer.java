package com.yxw.web.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author:阿倪
 * @Date: 2019/3/8 10:48
 * @Description:
 * @return:
 * @throws:
 */
@Component
public class JMSConsumer {
    private final static Logger logger = LoggerFactory.getLogger(JMSConsumer.class);

    @JmsListener(destination = "springboot.queue.test")
    public void receiveQueue(String msg) {
        logger.info("接收到消息：{}",msg);
    }
}
