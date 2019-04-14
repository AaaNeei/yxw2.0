package com.yxw.web.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public final static String DATE_FORMAT_DEFAULT = "yyyy-MM-dd";
    public final static String DATE_FORMAT_TIME = "yyyy-MM-dd HH:mm";
    public final static String DATE_FORMAT_ALL = "yyyy-MM-dd HH:mm:ss";
    public final static String DATE_CHINA_DEFAULT = "yyyy年MM月dd日";

    public static Date stringChangeDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_DEFAULT);
        Date parse = null;
        try {
            parse = sdf.parse(date);
        } catch (Exception e) {

        }
        return parse;
    }


}