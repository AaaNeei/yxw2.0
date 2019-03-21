package com.yxw.web.mapper;


import com.yxw.web.entity.Province;

import java.util.List;

/**
 * @Author:阿倪
 * @Date: 2019/3/8 20:31
 * @Description:
 * @return:
 * @throws:
 */
public interface ProvinceMapper {
    int insert(Province province);
    List<Province> selectAllProvince();
}
