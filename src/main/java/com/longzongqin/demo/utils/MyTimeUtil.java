package com.longzongqin.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTimeUtil {

    public static String getNowDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.format(new Date());
    }
    public static String getNowDateTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return sdf.format(new Date());
    }
}
