package com.yxw.web.mapper;


import com.yxw.web.entity.School;

import java.util.List;

/**
 * @Author:阿倪
 * @Date: 2019/3/8 20:31
 * @Description:
 * @return:
 * @throws:
 */
public interface SchoolMapper {
    int insert(School school);

    List<School> getSchoolByProvinceNum(Integer provinceNum);

    List<School> getSchoolAll();

}
