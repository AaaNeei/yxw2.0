package com.yxw.travel.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yxw.travel.entity.GoTravelGroup;
import com.yxw.travel.mapper.GoTravelMapper;
import com.yxw.travel.service.GoTravelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author:阿倪
 * @Date: 2019/3/27 21:13
 * @Description:
 * @return:
 * @throws:
 */
@Service
public class GoTravelServiceImpl implements GoTravelService {
    @Autowired
    private GoTravelMapper goTravelMapper;

    @Override
    public boolean insertGoTravel(GoTravelGroup goTravelGroup) {

        boolean result = goTravelMapper.insertGoTravel(goTravelGroup);
        return result;
    }

    @Override
    public boolean updateGoTravel(GoTravelGroup goTravelGroup) {
        boolean result = goTravelMapper.updateGoTravel(goTravelGroup);
        return result;
    }

    @Override
    public List<GoTravelGroup> selectAllGoTravel() {
        List<GoTravelGroup> goTravelGroups = goTravelMapper.selectAllGoTravel();
        return goTravelGroups;
    }
}
