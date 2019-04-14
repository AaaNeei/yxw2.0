package com.yxw.web.utils;

import com.yxw.web.entity.Student;
import com.yxw.web.entity.enumEntity.RedisKeyName;
import com.yxw.web.utils.security.Base64Utils;
import com.yxw.web.utils.security.MD5Util;
import com.yxw.web.utils.security.RSAUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author:阿倪
 * @Date: 2019/3/23 9:58
 * @Description:
 * @return:
 * @throws:
 */
@Service("encodeAndDecode")
public class EncodeAndDecode {

    /**
     * @param request redisType redisKeyName
     * @return 获取公钥
     */
    public String getPublicKey(RedisTemplate redisTemplate, HttpServletRequest request, String redisType) {
        String publicKey = "";
        try {
            //获取公钥
            Map<String, Object> keyMap = RSAUtils.genKeyPair();
            publicKey = RSAUtils.getPublicKey(keyMap);
            redisTemplate.opsForValue().set(redisType + request.getSession().getId(), RSAUtils.getPrivateKey(keyMap));
        } catch (Exception e) {

        }
        return publicKey;
    }

    /**
     * 对前端password解密 在后端进行md5加盐加密
     *
     * @param student
     * @param request
     * @param redisType
     * @return
     */
    public Student decodePassword(RedisTemplate redisTemplate, Student student, HttpServletRequest request, String redisType) {
        //获取私钥
        String privateKey = (String) redisTemplate.opsForValue().get(redisType + request.getSession().getId());
        //获取之后及时删除缓存
        redisTemplate.delete(redisType + request.getSession().getId());
        String password = student.getStuPassword();
        if (password == null || password == "") {
            return null;
        }
        password = password.replaceAll("%2B", "+");
        //解密后的密码
        String decodePassword = "";
        try {
            byte[] decryptByPrivateKey = RSAUtils.decryptByPrivateKey(Base64Utils.decode(password), privateKey);
            decodePassword = new String(decryptByPrivateKey);
        } catch (Exception e) {
            //后期要全局日志补货
        }
        //后端用MD5再次 加盐加密 存储数据库
        String MD5Password = MD5Util.encode(decodePassword);
        student.setStuPassword(MD5Password);
        return student;
    }

}
