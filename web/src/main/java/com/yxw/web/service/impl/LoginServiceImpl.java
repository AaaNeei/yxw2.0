package com.yxw.web.service.impl;

import com.yxw.web.config.HttpclientSpringConfig;
import com.yxw.web.entity.Student;
import com.yxw.web.entity.enumEntity.RedisKeyName;
import com.yxw.web.mapper.StudentMapper;
import com.yxw.web.service.LoginService;
import com.yxw.web.utils.EncodeAndDecode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

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
    @Autowired
    RedisTemplate redisTemplate;

    @Transactional
    @Override
    public Student login(Student student, HttpServletRequest request) {
        //获取前端解密  后端md5加密 的password对象
        student = new EncodeAndDecode().decodePassword(redisTemplate, student, request, RedisKeyName.YXW_PRIVATEKEY_LOGIN);
        Student loginStudent = studentMapper.selectByStudentLogin(student);
        return loginStudent;
    }
}
