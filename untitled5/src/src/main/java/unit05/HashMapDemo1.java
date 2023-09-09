package src.main.java.unit05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapDemo1 {
    public static void main(String[] args) {
        // 创建Map集合对象，根据课程查学分
        Map<String, Float> course = new HashMap<String, Float>();
        course.put("Java", new Float(3.0));
        course.put("Java EE", new Float(2.5));
        course.put("Android", new Float(2.5));

        // Map集合的相关方法
        Set<String> set = course.keySet();// 获取Map集合对象course中所有key对象的集合
        //HashSet<String> set = (HashSet<String>) course.keySet();
        System.out.println("Map集合大小：" + set.size());
        System.out.println("集合中包含课程JavaEE吗？：" + set.contains("JavaEE"));
        System.out.println("集合中包含课程Java EE吗？：" + set.contains("Java EE"));
        System.out.println("Java EE课程的学分：" + course.get("Java EE"));

        // 迭代Map集合
        System.out.println("使用迭代器遍历结果：");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String key = it.next();
            System.out.println(key + "---" + course.get(key));
        }
        // 迭代Map集合
        System.out.println("使用for循环遍历结果：");
        for (String key : set) {
            System.out.println(key + "---" + course.get(key));
        }
    }
}
