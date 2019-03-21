package com.yxw.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @Author:阿倪
 * @Date: 2019/3/12 22:24
 * @Description:
 * @return:
 * @throws:
 */

@Component
@Controller
public class ScheduledController {
    @Autowired
    //private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(ScheduledController.class);

    // 每天早八点到晚八点，间隔5分钟执行任务
    @Scheduled(cron = "0 0/5 8-20 * * ?")
    public void executeUploadTask() {

        // 间隔5分钟,执行工单上传任务
        Thread current = Thread.currentThread();
        logger.info("ScheduledTest.executeUploadTask 定时任务:" + current.getId() + ",name:" + current.getName());

        //每隔5分钟清空一次miss_number、allow_time
        //int intUpdateUser = userService.updateUserMissTimeAllowTime();
        logger.info("intUpdateUser:");

        /*<!-- 每隔5分钟清空一次miss_number、allow_time -->
  <update id="updateUserMissTimeAllowTime">
    update user
    set
      allow_time = null,
      miss_number = 0
  </update>
*/

    }


}
