package main.java.unit05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * Map方法entrySet()返回值类型 Set<Map.Entry<K, V>>
 * Entry是Map接口的内部接口
 * Entry提供了方法getKey()和getValue()
 * 结论：Entry提供了访问Map集合的另一种方法。
 */
public class MapAndSetDemo {
    public static void main(String[] args) {
        //创建一个Map集合
        Map<String, Float> courses = new HashMap<>();
        courses.put("Java面向对象程序设计",3.0f);
        courses.put("Java企业级开发", 2.5f);
        courses.put("Android移动开发",2.5f);

        //遍历方式一：使用键名的Set集合
        Set<String> keyNames=courses.keySet();
        Iterator<String> keyNameIters=keyNames.iterator();
        while(keyNameIters.hasNext()){
            String keyName=keyNameIters.next();
            System.out.println("课程：" +keyName + "，学分: "+courses.get(keyName));
        }

        //遍历方式二：使用接口Map的静态内部接口Entry
        System.out.println("-----------------------------------");
        Set<Map.Entry<String, Float>> entries = courses.entrySet();
        //获取迭代器
        Iterator<Map.Entry<String, Float>> iterator = entries.iterator();
        //迭代（遍历）
        while (iterator.hasNext()){
            Map.Entry<String, Float> entry = iterator.next();
            System.out.println(entry);  //默认输出
            System.out.println(entry.getKey()+"课程的学分是："+courses.get(entry.getKey()));  //自定义输出
        }
    }
}
