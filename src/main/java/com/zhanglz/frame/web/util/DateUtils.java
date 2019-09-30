package com.zhanglz.frame.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static String longTimeToDate(long time){
        return df1.format(new Date(time));
    }
}
