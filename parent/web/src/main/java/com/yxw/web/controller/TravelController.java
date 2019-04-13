package com.yxw.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yxw.travel.entity.GoTravelGroup;
import com.yxw.travel.enumUtil.TravelGroupState;
import com.yxw.travel.service.GoTravelService;
import com.yxw.web.annotation.UserInformationAnnotation;
import com.yxw.web.entity.Student;
import com.yxw.web.entity.enumEntity.RedisKeyName;
import com.yxw.web.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author:阿倪
 * @Date: 2019/3/23 15:22
 * @Description:
 * @return:
 * @throws:
 */
@Controller
@RequestMapping("/yxw/travel")
public class TravelController {
    @Reference
    private GoTravelService goTravelService;

    /**
     * @return 旅行者们  团队信息
     */
    @UserInformationAnnotation
    @RequestMapping("/travelGroup")
    public String travelGroup(HttpServletRequest request, Model model) {


        return "/travel/travelGroup";

    }

    /**
     * 去旅行  自己的计划
     *
     * @return
     */
    @UserInformationAnnotation
    @RequestMapping("/goTravel")
    public String goTravel(HttpServletRequest request, Model model, GoTravelGroup goTravelGroup) {


        return "/travel/goTravel";

    }

    /**
     * 去旅行  自己的计划
     *
     * @return
     */
    @Autowired
    private RedisTemplate redisTemplate;

    @UserInformationAnnotation
    @RequestMapping("/goTravelUp")
    public String goTravelUp(HttpServletRequest request, Model model, Student student, GoTravelGroup goTravelGroup,
                             String groupTravelEndTimeStr, String groupTravelStartTimeStr) {

        Date groupTravelEndTime = DateUtils.stringChangeDate(groupTravelEndTimeStr);
        Date groupTravelStartTime = DateUtils.stringChangeDate(groupTravelStartTimeStr);
        goTravelGroup.setGroupTravelEndTime(groupTravelEndTime);
        goTravelGroup.setGroupTravelStartTime(groupTravelStartTime);
        goTravelGroup.setCreateTime(new Date());
        goTravelGroup.setGroupState(TravelGroupState.TRAVEL_GROUP_STATE_WAITING.getValue());
        boolean result = goTravelService.insertGoTravel(goTravelGroup);
        if (!result) {
            return "/error/404";
        }
        model.addAttribute("goTravelGroup", goTravelGroup);
        return "/travel/travelPlan";

    }

    /**
     * 提交goTravel
     */
    @RequestMapping("/goTravelStart")
    public String goTravelStart(HttpServletRequest request, Model model, Student student, GoTravelGroup goTravelGroup,
                                String groupTravelEndTimeStr, String groupTravelStartTimeStr) {
        return "/travel/travelPlan";
    }

    /**
     * 自己的计划  进展
     *
     * @return
     */
    @UserInformationAnnotation
    @RequestMapping("/travelPlan")
    public String travelPlan(HttpServletRequest request, Model model) {


        return "/travel/travelPlan";

    }

    /**
     * 自己的旅游过往记录
     *
     * @return
     */
    @UserInformationAnnotation
    @RequestMapping("/backTravel")
    public String backTravel(HttpServletRequest request, Model model) {


        return "/travel/backTravel";

    }

}
