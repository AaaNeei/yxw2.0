package com.yxw.web.mapper;

import com.yxw.web.entity.MobileCode;

/**
 * @Author:阿倪
 * @Date: 2019/3/17 21:32
 * @Description:
 * @return:
 * @throws:
 */
public interface SmsMapper {

    public Integer sendMessageDev(MobileCode mobileCode);
}
