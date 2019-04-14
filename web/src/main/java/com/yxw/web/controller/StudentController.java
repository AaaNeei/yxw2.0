package com.yxw.web.controller;


import com.yxw.web.annotation.UserInformationAnnotation;
import com.yxw.web.entity.Student;
import com.yxw.web.entity.enumEntity.RedisKeyName;
import com.yxw.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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


 /*   @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return studentService.findAllUser(pageNum, pageSize);
    }
*/
    /**
     * 进入首页
     *
     * @param
     * @return
     */
    @UserInformationAnnotation
    @RequestMapping("/index")
    public String index(HttpServletRequest request, Model model) {
        return "/index";
    }




}
