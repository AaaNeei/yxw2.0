package com.yxw.web.mapper;


import com.yxw.web.entity.City;

/**
 * @Author:阿倪
 * @Date: 2019/3/8 20:31
 * @Description:
 * @return:
 * @throws:
 */
public interface CityMapper {
    int insert(City city);
    City selectCityNum(String cityName);
}
