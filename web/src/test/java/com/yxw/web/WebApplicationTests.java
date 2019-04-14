package com.yxw.web;

import com.yxw.web.utils.security.RSAUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebApplicationTests {

    @Test
    public void contextLoads() {

        String publicKey = "";
        try {
            //获取公钥
            Map<String, Object> keyMap = RSAUtils.genKeyPair();
            publicKey = RSAUtils.getPublicKey(keyMap);
            String privateKey = RSAUtils.getPrivateKey(keyMap);
            System.out.print(publicKey);
            System.out.print(privateKey);
        } catch (Exception e) {

        }
    }

}
