package com.yxw.web.controller;

import com.yxw.web.entity.MobileCode;
import com.yxw.sms.service.SmsService;
import com.yxw.web.entity.Province;
import com.yxw.web.entity.School;
import com.yxw.web.entity.Student;
import com.yxw.web.entity.enumEntity.RedisKeyName;
import com.yxw.web.service.ProvinceService;
import com.yxw.web.service.RegisterService;
import com.yxw.web.service.SchoolService;
import com.yxw.web.service.StudentService;
import com.yxw.web.utils.EncodeAndDecode;
import com.yxw.web.utils.security.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author:阿倪
 * @Date: 2019/3/7 20:59
 * @Description:
 * @return:
 * @throws:
 */
@Controller
@RequestMapping("/yxw")
public class RegisterController {

    @Reference
    private SmsService smsService;

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private SchoolService schoolService;
    @Autowired
    private StudentService studentService;
    @Value("${yxw.environment:dev}")
    private String environment;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RegisterService registerService;


    /**
     * 发送短信
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/ajaxCheckMobileCode.json", method = RequestMethod.POST)
    public String getSchoolByProvinceNum(@RequestParam(value = "stuMobile") String stuMobile) {
        //调用 中国网建sms平台 真实发送短信
        String message = null;
        if (StringUtils.pathEquals("pro", environment)) {
            message = smsService.sendMessage(stuMobile);
        } else if (StringUtils.pathEquals("dev", environment)) {
            //开发环境 不发送短信只存数据库  缓存
            message = registerService.sendMessageDev(stuMobile);
        }

        return message;
    }

    /**
     * 根据省份编号获取所在省份高校
     *
     * @param provinceNum
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register_getSchoolByProvinceNum.json", method = RequestMethod.GET)
    public List<School> ajaxCheckMobileCode(@RequestParam(value = "provinceNum") Integer provinceNum) {

        List<School> schoolList = schoolService.getSchoolByProvinceNum(provinceNum);

        return schoolList;
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerView(Model model, HttpServletRequest request) {

        /*//查询所有省信息
        List<Province> provinceList = provinceService.selectAllProvince();
        model.addAttribute("provinceList", provinceList);*/
        String publicKey = new EncodeAndDecode().getPublicKey(redisTemplate, request, RedisKeyName.YXW_PRIVATEKEY_REGISTER);
        model.addAttribute("publicKey", publicKey);

        return "/register";
    }

    /**
     * 注册提交数据
     *
     * @param model
     * @param student
     * @param stuMobileCode
     * @return
     */
    @RequestMapping(value = "/registerIn", method = RequestMethod.POST)
    public String register(Model model, Student student, HttpServletRequest request, @RequestParam(value = "stuMobileCode") String stuMobileCode) {


        System.out.print("----------注册数据提交");
        String mobileCode = (String) redisTemplate.opsForValue().get(RedisKeyName.YXW_SMS_CODE_DEV + student.getStuMobile());
        redisTemplate.delete(RedisKeyName.YXW_SMS_CODE_DEV + student.getStuMobile());
        if (!StringUtils.pathEquals(stuMobileCode, mobileCode)) {
            model.addAttribute("msg", "手机验证码不一致!");
            return "/error";
        }
        studentService.addUser(student, request);
        model.addAttribute("flag", "success");
        return "/page_search";
    }

    @ResponseBody
    @RequestMapping(value = "/ajaxCheckStuUsername.json", method = RequestMethod.POST)
    public String ajaxCheckStuUsername(String stuUsername) {
        Student student = studentService.ajaxCheckStuUsername(stuUsername);
        if (student != null) {
            return "1";
        }
        return "0";
    }


   /* @ResponseBody
    @RequestMapping("/register")
    public Msg Register(String name,String password) {
        //判断该用户名是否已被注册
        boolean num = userService.userRegister(name);

        if (num == false) {
            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put("username", "用户名已被注册");
            return Msg.error().add("map", map2);
        } else {
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            //新注册用户错误次数都为0
            user.setMissNumber(0);
            //1超级管理员:直接修改数据库的用户，只能打开mySQL改的
            //2普通会员:通过请求注册的用户
            user.setRoleId(2);
            int flag = userService.userInsert(user);

            if (flag==1) {
                return Msg.success();
            } else {
                return Msg.error();
            }
        }
    }*/


}
