package com.yxw.web.controller;

import com.yxw.web.annotation.UserInformationAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
    public String goTravel(HttpServletRequest request, Model model) {


        return "/travel/goTravel";

    }

    /**
     * 去旅行  自己的计划
     *
     * @return
     */
    @UserInformationAnnotation
    @RequestMapping("/goTravelUp")
    public String goTravelUp(HttpServletRequest request, Model model) {


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
