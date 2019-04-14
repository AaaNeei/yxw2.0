package com.yxw.web.service;

import com.yxw.web.entity.Student;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:阿倪
 * @Date: 2019/3/11 21:19
 * @Description:
 * @return:
 * @throws:
 */
public interface LoginService {
    Student login(Student student, HttpServletRequest request);

}
