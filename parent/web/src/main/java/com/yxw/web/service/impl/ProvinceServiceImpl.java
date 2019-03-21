package com.yxw.web.service.impl;

import com.yxw.web.entity.Province;
import com.yxw.web.mapper.ProvinceMapper;
import com.yxw.web.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:阿倪
 * @Date: 2019/3/10 16:32
 * @Description:
 * @return:
 * @throws:
 */
@Service("provinceService")
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public List<Province> selectAllProvince() {

        List<Province> provinceList = provinceMapper.selectAllProvince();

        return provinceList;
    }
}
