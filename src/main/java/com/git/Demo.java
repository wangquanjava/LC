package com.git;

/**
 * @author wangquan07
 * 2019/9/30 16:44
 */
public class Demo {
    public static String s1 = "11";
    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);


        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";


        System.out.println(s3 == s4);

    }
}
