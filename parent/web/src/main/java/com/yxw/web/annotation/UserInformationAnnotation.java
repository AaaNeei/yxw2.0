package com.yxw.web.annotation;

import java.lang.annotation.*;

/**
 * @Author:阿倪
 * @Date: 2019/3/24 16:00
 * @Description:
 * @return:
 * @throws: 用户登录信息返回到页面的统一获取注解
 */

@Inherited
//给方法用的注解
@Target(ElementType.METHOD)
//级别
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserInformationAnnotation {
}
