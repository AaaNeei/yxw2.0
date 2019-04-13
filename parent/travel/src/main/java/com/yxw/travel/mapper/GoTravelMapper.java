package com.yxw.travel.mapper;

import com.yxw.travel.entity.GoTravelGroup;

import java.util.List;

/**
 * @Author:阿倪
 * @Date: 2019/3/27 20:15
 * @Description:
 * @return:
 * @throws:
 */
public interface GoTravelMapper {
    /**
     * 插入去旅行的组队信息
     *
     * @return
     */
    boolean insertGoTravel(GoTravelGroup goTravelGroup);

    /**
     * 修改去旅行的组队信息(目前是状态)
     *
     * @return
     */
    boolean updateGoTravel(GoTravelGroup goTravelGroup);

    /**
     * 查询所有组队信息
     *
     * @return
     */
    List<GoTravelGroup> selectAllGoTravel();
}
