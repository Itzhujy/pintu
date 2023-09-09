package main.java.unit05.ext;


/**
 *
 *
 *   2023.1.25
 *
 */

import org.junit.Test;

import java.util.*;

public class testHashSetAndTreeSet {
    @Test
    public void hashSet() {
        //在集合中不满12个元素 且存储单个字符时；元素的存储位置可以概括为：余数=哈希值%16, 如 51%16 = 3, 49%16=1, 50%16=2

        //(1)HashSet
        //单个数字(字符)时, 这些HashCode是按照ASCII码计算和排序的
        Set<String> hashSet = new HashSet<>();  //default capacity: 16, scale: 0.75
        hashSet.add("3");
        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("1");     //重复项不会被添加
        System.out.println("[element:hashCode]->"+hashSet); //返回此集合的字符串表示形式。 字符串表示由集合的元素的列表按照它们的迭代器返回的顺序包含在方括号("[]")中。
        for (String s : hashSet) {
            System.out.print(s + ":"+s.hashCode()+" ");
        }
        System.out.println();

        //设置迭代器，输出HashSet中的对象
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            Object obj=iterator.next();
            System.out.print(obj + ":"+obj.hashCode()+" ");
        }
        System.out.println();


        //单个字母时
        Set<String> hashSet2 = new HashSet<>();
        hashSet2.add("J");
        hashSet2.add("A");
        hashSet2.add("T");
        System.out.println("[element:hashCode]->"+hashSet2);
        for (String s : hashSet2) {
            System.out.print(s + ":"+s.hashCode()+" ");
        }
        System.out.println();

        //多个数字时, Integer类型hashCode()的返回值就是其int值本身，而存储的时候元素通过一些运算(hashcode & (tab.length-1))后会得出自己在数组中所处的位置
        Set<Integer> intSet = new HashSet<>(10);
        intSet.add(3);  //2345
        intSet.add(1);  //6257
        intSet.add(2);  //1234
        System.out.println("[element:hashCode]->"+intSet);
        for (Integer s : intSet) {
            System.out.print(s + ":"+s.hashCode()+" ");
        }
        System.out.println();

       //多个字母时
        Set<String> nameSet = new HashSet<>();
        nameSet.add("Jim");
        nameSet.add("Alice");
        nameSet.add("Tom");
        System.out.println("[element:hashCode]->"+nameSet);
        for (String s : nameSet) {
            System.out.print(s + ":"+s.hashCode()+" ");
        }
        System.out.println();

    }


    @Test
    public void LinkedHashSet(){
        //可以使存放到集合中的元素有序, LinkedHashset 是由链表和哈希表（由数组+链表/红黑树）组成的一个数据储存结构, 不仅元素唯一,还保持存储和读取顺序是相同的，即有序。
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Jim");
        linkedHashSet.add("Alice");
        linkedHashSet.add("Tom");
        linkedHashSet.add("Alice");
        System.out.println("[element:hashCode]->"+linkedHashSet);
        Iterator<String> il = linkedHashSet.iterator();
        while (il.hasNext()){
            System.out.println(il.next());
        }
    }


    @Test
    public void treeSet() {
        //TreeSet中元素做了排序,输出了自然排序(默认升序)后的结果

        //单个数字时
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("3");
        treeSet.add("1");
        treeSet.add("2");
        System.out.println("[element:hashCode]->"+treeSet);
        for (String s : treeSet) {
            System.out.print(s + ":"+s.hashCode()+" ");
        }
        System.out.println();

        //设置迭代器，输出TreeSet中的对象
        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            Object obj=iterator.next();
            System.out.print(obj + ":"+obj.hashCode()+" ");
        }
        System.out.println();


        //单个字母时
        Set<String> treeSet2 = new TreeSet<>();
        treeSet2.add("J");
        treeSet2.add("A");
        treeSet2.add("T");
        System.out.println("[element:hashCode]->"+treeSet2);
        for (String s : treeSet2) {
            System.out.print(s + ":"+s.hashCode()+" ");
        }
        System.out.println();

        //多个数字时
        Set<Integer> inttSet = new TreeSet<>();
        inttSet.add(1234);
        inttSet.add(6257);
        inttSet.add(2345);
        System.out.println("[element:hashCode]->"+inttSet);
        for (Integer s : inttSet) {
            System.out.print(s + ":"+s.hashCode()+" ");
        }
        System.out.println();

        //多个字母时
        Set<String> nametSet = new TreeSet<>();
        nametSet.add("Jim");
        nametSet.add("Alice");
        nametSet.add("Tom");
        System.out.println("[element:hashCode]->"+nametSet);
        for (String s : nametSet) {
            System.out.print(s + ":"+s.hashCode()+" ");
        }
        System.out.println();

    }
}