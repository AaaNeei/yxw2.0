package com.yxw.web.controller;


import com.yxw.web.entity.Student;
import com.yxw.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Set;

/**
 * @Author:阿倪
 * @Date: 2019/3/6 13:25
 * @Description:
 * @return:
 * @throws:
 */
@Controller
@RequestMapping("/yxw")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private RedisTemplate redisTemplate;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(Student student) {
        student.setCreateTime(new Date());
        return studentService.addUser(student);
    }

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return studentService.findAllUser(pageNum, pageSize);
    }

    /**
     * 进入首页
     *
     * @param
     * @return
     */
    @RequestMapping("/index")
    public String index() {

            return "/index";
    }

    @RequestMapping("/hello")
    public String index1() {

        return "/you/login";
    }


}
