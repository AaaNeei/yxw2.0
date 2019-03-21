package com.yxw.web.service;


import com.yxw.web.entity.Student;

import java.util.List;

/**
 * @Author:阿倪
 * @Date: 2019/3/6 9:46
 * @Description:
 * @return:
 * @throws:
 */

public interface StudentService {
    int addUser(Student student);

    List<Student> findAllUser(int pageNum, int pageSize);

    Student ajaxCheckStuUsername(String stuUsername);
}
