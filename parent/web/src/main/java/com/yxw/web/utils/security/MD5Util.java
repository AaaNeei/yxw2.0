package com.yxw.web.utils.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.security.MessageDigest;

/**
 * @Author:阿倪
 * @Date: 2019/3/14 16:32
 * @Description:
 * @return:
 * @throws:
 */
public class MD5Util {

    @Value("${yxw.security.salt}")
    private static String yxwSalt;
    private static final String SALT = "yxw$_AaNeei@1995*02!01";

    public static String encode(String password) {
        password = yxwSalt + password + SALT;
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        char[] charArray = password.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }

            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    public static void main(String[] args) {
        System.out.println(MD5Util.encode("abel"));


    }


}
