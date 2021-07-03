package com.cjcStudying.utls;

import java.io.UnsupportedEncodingException;

public class NameUtils {

    public static String encodingName(String name){
        String now = name;
        try {
            now = new String(name.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        System.out.println(now);
        return now;
    }
}
