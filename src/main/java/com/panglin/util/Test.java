package com.panglin.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Pang-Lin
 * @version 1.0
 * @description: TODO
 * @date 2021/7/24 17:17
 */
public class Test {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format1 = new SimpleDateFormat(
                "yyyy-MM-dd");
        java.util.Date date = format1.parse("2021-7-24");
        SimpleDateFormat format2 = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        String sdate = format2.format(date);
        Timestamp  fTimestamp = Timestamp.valueOf(sdate);
        System.out.println(fTimestamp);
    }
}
