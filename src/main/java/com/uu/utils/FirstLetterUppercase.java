package com.uu.utils;

/**
 * @Description：
 * @Date: 2021/6/22
 * @Author: liangqing 道玄
 * @Email: clarence_liang@163.com
 */
public class FirstLetterUppercase {
    public static String upperFirstLatter2(String letter){
        return letter.substring(0, 1).toUpperCase()+letter.substring(1);
    }
}
