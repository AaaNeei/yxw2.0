package com.yxw.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:阿倪
 * @Date: 2019/3/23 15:48
 * @Description:
 * @return:
 * @throws:
 */
@Controller
@RequestMapping("/yxw/error")
public class ErrorController {

    @RequestMapping(value = "/{code}")
    public String error(@PathVariable int code, Model model) {
        String pager = "/error/error-pager";
        switch (code) {
            case 404:
                model.addAttribute("code", 404);
                pager = "/error/error-pager";
                break;
            case 500:
                model.addAttribute("code", 500);
                pager = "/error/error-pager";
                break;
        }
        return pager;
    }

}
