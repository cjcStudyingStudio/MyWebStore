package com.cjcStudying.utls;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    static SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");

    public static Date getDate(String date){
                Timestamp timestamp = null;
        try {
            Date date1 = dateFormat.parse(date);
            timestamp = new Timestamp(date1.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timestamp;
    }

    public static Date setDate(Date date){
        String format = dateFormat.format(date);
        System.out.println("DateUtils:"+format);
        try {
            date = dateFormat.parse(format);
            System.out.println("DateUtils:"+date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
