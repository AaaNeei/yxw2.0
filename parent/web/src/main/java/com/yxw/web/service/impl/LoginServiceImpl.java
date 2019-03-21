package com.yxw.web.service.impl;

import com.yxw.web.entity.Student;
import com.yxw.web.mapper.StudentMapper;
import com.yxw.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:阿倪
 * @Date: 2019/3/11 21:20
 * @Description:
 * @return:
 * @throws:
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private StudentMapper studentMapper;


    @Transactional
    @Override
    public Student login(Student student) {
        Student loginStudent = studentMapper.selectByStudentLogin(student);
        return loginStudent;
    }
}
