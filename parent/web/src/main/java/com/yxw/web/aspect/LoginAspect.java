package com.yxw.web.aspect;


import com.yxw.web.annotation.UserInformationAnnotation;
import com.yxw.web.entity.Student;
import com.yxw.web.entity.enumEntity.RedisKeyName;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

@DependsOn("springApplicationContextHolder")
@Configuration
@Component
@Aspect
public class LoginAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoginAspect.class);

    ThreadLocal<Long> startTimeThreadLocal = new ThreadLocal<Long>();

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    /**
     * aspect不在spring容器中,要认为注入
     *
     * @return
     */
    public static LoginAspect aspectOf() {
        return SpringApplicationContextHolder.getApplicationContext().getBean(LoginAspect.class);
    }

    /**
     * 扫包形式
     */
    /*@Pointcut("execution(public * com.yxw.web.controller..*.*(..))")
    public void login() {
    }
*/

    /**
     * 扫描是否添加注解形式
     */
    @Pointcut("@annotation(com.yxw.web.annotation.UserInformationAnnotation)")
    public void login() {
    }

    @Before("login()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        logger.info("aop前置对象开始---->增强model");
        startTimeThreadLocal.set(System.currentTimeMillis());
        Object[] args = joinPoint.getArgs();
        Student student = null;
        HttpServletRequest request = null;
        Model model = null;
       /* for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof HttpServletRequest) {
                request = (HttpServletRequest) args[i];
                student = (Student) redisTemplate.opsForValue().get(RedisKeyName.YXW_LOGIN_STUDENT + request.getSession().getId());
                if (student != null) {
                    for (int j = 0; j < args.length; j++) {
                        if (args[j] instanceof Model) {
                            model = (Model) args[j];
                            model.addAttribute("student", student);
                            break;
                        }
                    }
                }
            }
        }*/
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof HttpServletRequest) {
                request = (HttpServletRequest) args[i];
                student = (Student) redisTemplate.opsForValue().get(RedisKeyName.YXW_LOGIN_STUDENT + request.getSession().getId());
                if (student != null && model != null) {
                    model.addAttribute("student", student);
                    break;
                }
            }
            if (args[i] instanceof Model) {
                model = (Model) args[i];
                if (student != null && model != null) {
                    model.addAttribute("student", student);
                    break;
                }
            }

        }

        logger.info("获取student用户对象--->" + student);


    }

    @AfterReturning(pointcut = "login()")
    public void doAfterReturning(JoinPoint joinPoint) throws Throwable {

    }

}