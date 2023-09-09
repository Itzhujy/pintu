package main.java.unit05;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Hashtable和HashMap都是基于哈希表实现
 * Hashtable是线程安全的，能用于多线程环境中。
 * HashMap线程不安全
 */
class HashtableDemo {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();  //创建Hashtable对象
        hashtable.put("one", new Integer(1));
        hashtable.put("two", new Integer(2));
        hashtable.put("three", new Integer(3));

        //传统的枚举接口Enumeration已经被很少使用，并被迭代器取代。
        Enumeration enumeration = hashtable.keys();  //获取键名集合
        while (enumeration.hasMoreElements()) {
            Object key = enumeration.nextElement();
            Object value = hashtable.get(key);
            System.out.println("key="+key+"，value="+value);
        }
    }
}

