package com.yxw.web.mapper;


import com.yxw.web.entity.Student;

import java.util.List;

/**
 * @Author:阿倪
 * @Date: 2019/3/6 10:38
 * @Description:
 * @return:
 * @throws:
 */

public interface StudentMapper {

    int deleteByPrimaryKey(Integer userId);

    int insert(Student student);

    int insertSelective(Student student);

    Student selectByPrimaryKey(Integer stuId);

    Student selectByStudentLogin(Student student);

    int updateByPrimaryKeySelective(Integer stuId);

    //int updateByPrimaryKey(Integer stuId);
    //
    List<Student> selectAllStudent();

    Student ajaxCheckStuUsername(String stuUsername);

}
