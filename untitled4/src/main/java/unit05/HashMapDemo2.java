package main.java.unit05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 二维表数据的存储及显示
 * 方法一：在List集合里嵌套Map集合
 */

public class HashMapDemo2 {
    public static void main(String[] args) {
        List<Map<String, Object>> persons = new ArrayList<Map<String, Object>>();  //二维表数据
        Map<String, Object> person1 = new HashMap<String, Object>();  //记录
        person1.put("id", 1);
        person1.put("name", "张三");
        person1.put("salary", 5000);
        persons.add(person1);
        Map<String, Object> person2 = new HashMap<String, Object>();
        person2.put("id", 2);
        person2.put("name", "李四");
        person2.put("salary", 5800);
        persons.add(person2);
        Map<String, Object> person3 = new HashMap<String, Object>();
        person3.put("id", 3);
        person3.put("name", "王五");
        person3.put("salary", 5500);
        persons.add(person3);
        System.out.println("遍历结果如下：");
        for(int i=0;i<persons.size();i++) {
            System.out.println(persons.get(i));
        }
    }
}
