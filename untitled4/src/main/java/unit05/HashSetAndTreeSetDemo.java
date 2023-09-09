package main.java.unit05;

import org.junit.Test;

import java.util.*;

public class HashSetAndTreeSetDemo {
    @Test
    public void calStringHash(){
        /**
         * 字符串的hashcode计算方式为，以31为权重，举例计算字符串“java”的hashcode
         * j 的 ASCII码 为 106，可使用 Integer.valueOf('j')获取
         * a 的 ASCII码 为 97
         * v 的 ASCII码 为 118
         * 字符串 va 的 hashcode为 118 * 31 + 97
         * 字符串 java 的 hashcode为 106 * 31 * 31 * 31  + 97 * 31 * 31 + 118 * 31 + 97
         */
        int hashcode = 106 * 31 * 31 * 31  + 97 * 31 * 31 + 118 * 31 + 97;
        System.out.println("hashCode计算的值:" + hashcode);   //3254818
        System.out.println("Objects hashCode:" + Objects.hashCode("java") ); //3254818
        System.out.println("String hashCode:" + "java".hashCode()); //3254818
        //Objects.hash在上面的计算方式基础上额外增加了31
        System.out.println("Objects hash:" + (3254818 + 31));  //3254849
        System.out.println("Objects hash:" + Objects.hash("java") ); //3254849
    }

    @Test
    public void hashSet() {
        //HashSet底层使用HashMap实现（HashSet元素作为HashMap的key），以保证元素不会重复
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Alice");
        hashSet.add("Jim");
        hashSet.add("Tom");
        hashSet.add("bxy");
        hashSet.add("wzx");
        hashSet.add("zzf");

        for(String s : hashSet){
            int h=s.hashCode();  //哈希码
            int hash= (h ^ (h >>> 16));  //HashMap里计算的哈希值（对哈希码进行了微小的扰动：>>>无符号右移；^按位异或）
            int n=16;  //Hash表默认长度为 16；负载因子默认为 0.75（当Hash表元素个数超过12时，容量n自动翻倍）
            int i=(n-1) & hash;  //此处&是按位与（不是逻辑与）；散列地址i是遍历哈希集的依据
            System.out.println(s + "-"+h+"-"+i);  //验证（i从小到大）
        }
        short a=8;
        System.out.println(~a);
    }

    @Test
    public void treeSet() {
        //使用TreeSet进行自动排序（ASCII码序）
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Jim");
        treeSet.add("Alice");
        treeSet.add("Tom");
        //设置迭代器，输出TreeSet中的对象
        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
