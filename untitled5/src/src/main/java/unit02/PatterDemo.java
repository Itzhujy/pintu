package src.main.java.unit02;

import java.util.regex.Pattern;

public class PatterDemo {
    public static void main(String[] args) {
        //模式类Pattern与正则表达式
        System.out.println(Pattern.matches("1\\d*", "1"));  //输出：true
        System.out.println(Pattern.matches("1\\d*", "199"));  //输出：true
        System.out.println(Pattern.matches("1\\d*", "9"));  //输出：false
        System.out.println(Pattern.matches("\\wo{2}\\w", "food"));  //输出：true
    }
}
