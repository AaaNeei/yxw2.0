package com.yxw.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping("/travelGroup")
    public String travelGroup() {


        return "/travel/travelGroup";

    }

    /**
     * 去旅行  自己的计划
     *
     * @return
     */
    @RequestMapping("/goTravel")
    public String goTravel() {


        return "/travel/goTravel";

    }

    /**
     * 自己的计划  进展
     *
     * @return
     */
    @RequestMapping("/travelPlan")
    public String travelPlan() {


        return "/travel/travelPlan";

    }

    /**
     * 自己的旅游过往记录
     *
     * @return
     */
    @RequestMapping("/backTravel")
    public String backTravel() {


        return "/travel/backTravel";

    }

}
