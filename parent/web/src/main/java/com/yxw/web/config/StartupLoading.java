package com.yxw.web.config;

import com.yxw.web.entity.Province;
import com.yxw.web.entity.School;
import com.yxw.web.service.ProvinceService;
import com.yxw.web.service.SchoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author:阿倪
 * @Date: 2019/3/10 21:37
 * @Description:
 * @return:
 * @throws:
 */
@Component
public class StartupLoading implements CommandLineRunner {

    public Logger log = LoggerFactory.getLogger(StartupLoading.class);
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SchoolService schoolService;

    @Override
    public void run(String... var1) throws Exception {


        log.info("------------------项目启动,开始加载相关数据到redis缓存");
        List<Province> yxw_provinceList_v01 = redisTemplate.opsForList().range("yxw_provinceList_v01", 0, -1);
        if (yxw_provinceList_v01 == null || yxw_provinceList_v01.isEmpty()) {
            //省份信息存入缓存,如果不存在的情况下
            log.info("------------------province放入缓存");
            List<Province> provinceList = provinceService.selectAllProvince();
            redisTemplate.opsForList().rightPushAll("yxw_provinceList_v01", provinceList);
        }
        log.info("------------------province从缓存读取");
        //所有高校信息存入缓存
       /* List<School> schoolList = schoolService.getSchoolAll();
       //数据量过大,redis只能存储1000个school对象就结束.....
        redisTemplate.opsForList().rightPushAll("yxw_shcoolList_v01",schoolList);*/

        Map<String, List<School>> schoolAllByProvince = redisTemplate.opsForHash().entries("schoolAllByProvince");
        if (schoolAllByProvince.isEmpty()) {
            log.info("------------------province_school放入缓存");
            schoolAllByProvince = schoolService.getSchoolAllByProvince();
            redisTemplate.opsForHash().putAll("schoolAllByProvince", schoolAllByProvince);
        }
        log.info("------------------province_school从缓存读取");
        log.info("------------------相关数据加载完成");


    }

}
