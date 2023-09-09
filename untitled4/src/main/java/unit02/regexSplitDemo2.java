package main.java.unit02;

import java.util.regex.Pattern;

public class regexSplitDemo2 {
    public static void main(String[] args) {
        // 查找逗号，空格（空格，制表符，换行，回车，换页）。
        /*String pattern = "[,\\s<?>]+";
        String colors = "Red<,White, Blue   Green        " +
                "Yellow, Orange?>";
        Pattern splitter = Pattern.compile(pattern);
        String[] result = splitter.split(colors);

        for (String color : result) {
            System.out.format("%s\n", color);
        }*/

        String source2="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "    <string xmlns=\"http://WebXml.com.cn/\">1552764：湖北 武汉 湖北联通GSM卡</string>";
        String resultText=source2.replaceAll("</?[^>]+>","").trim();  //</?[^>]+>
        System.out.println(resultText);
    }
}
