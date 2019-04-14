package com.yxw.web.service.impl;

import com.yxw.web.entity.Province;
import com.yxw.web.entity.School;
import com.yxw.web.mapper.SchoolMapper;
import com.yxw.web.service.ProvinceService;
import com.yxw.web.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:阿倪
 * @Date: 2019/3/10 17:29
 * @Description:
 * @return:
 * @throws:
 */
@Service("schoolService")
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override

    public List<School> getSchoolByProvinceNum(Integer provinceNum) {
        List<School> schoolList = schoolMapper.getSchoolByProvinceNum(provinceNum);

        return schoolList;
    }

    @Override
    public Map<String, List<School>> getSchoolAllByProvince() {

        //List<School> schoolAll = schoolMapper.getSchoolAll();
        Map<String, List<School>> map = new HashMap<>();
        //配合初始加载  已经可以 从缓存中获取数据
        List<Province> provinceList = redisTemplate.opsForList().range("yxw_provinceList_v01", 0, -1);
        for (Province province : provinceList) {
            List<School> schoolByProvinceNum = schoolMapper.getSchoolByProvinceNum(province.getProvinceNum());
            if (!schoolByProvinceNum.isEmpty()) {
                map.put("yxw_schoolByProvinceNum_" + province.getProvinceNum(), schoolByProvinceNum);
            }
        }

        return map;
    }
}
