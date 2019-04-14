package com.yxw.web.service.impl;

import com.github.pagehelper.PageHelper;

import com.yxw.web.entity.Student;
import com.yxw.web.entity.enumEntity.RedisKeyName;
import com.yxw.web.mapper.StudentMapper;
import com.yxw.web.service.StudentService;
import com.yxw.web.utils.EncodeAndDecode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author:阿倪
 * @Date: 2019/3/6 13:22
 * @Description:
 * @return:
 * @throws:
 */
@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public int addUser(Student student, HttpServletRequest request) {
        //获取前端解密  后端md5加密 的password对象
        student = new EncodeAndDecode().decodePassword(redisTemplate, student, request, RedisKeyName.YXW_PRIVATEKEY_REGISTER);
        return studentMapper.insert(student);
    }

    @Override
    public List<Student> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return studentMapper.selectAllStudent();
    }

    @Override
    public Student ajaxCheckStuUsername(String stuUsername) {
        Student student = studentMapper.ajaxCheckStuUsername(stuUsername);
        return student;
    }


}
