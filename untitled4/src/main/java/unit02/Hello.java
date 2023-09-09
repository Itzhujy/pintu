package main.java.unit02;

import java.util.ArrayList;
import java.util.List;

public class Hello {
    static boolean b;
    static Boolean yn;
    public static void main(String[] args) {
        String s="Hello";
        s=s+" world!";
        System.out.println(s);
        System.out.println(b);
        System.out.println(yn);

        List<String> cities = new ArrayList<>();
        //真正的数据在heap里，cities只是对heap里对象的引用
        cities.add("Beijing");
        
    }
}
