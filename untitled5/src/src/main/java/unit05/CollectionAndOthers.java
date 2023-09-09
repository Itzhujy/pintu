package src.main.java.unit05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionAndOthers {
    public static void main(String[] args) {
        //ArrayList<String> cities=new ArrayList<>();
        //List<String> cities=new ArrayList<>();  //向上转型
        Collection<String> cities=new ArrayList<>();  //再向上转型
        cities.add("北京");
        cities.add("上海");
        cities.add("深圳");
        System.out.println("集合空吗？"+cities.isEmpty());
        System.out.println("集合大小："+cities.size());
        //接口Collection继承接口Iterable，Iterable定义了返回值为接口Iterator类型的抽象方法iterator()
        Iterator<String> iterator = cities.iterator();
        System.out.println(iterator);

        //接口Iterator定义了遍历的方法hasNext()和next()
        while (iterator.hasNext()) {  //输入itit快速产生
            System.out.println(iterator.next());
        }
        cities.add("北京");
        List<String> cities2=(List)cities;
        //List集合具有get()方法，Collection集合不具有方法get()
        System.out.println(cities2.get(0)+cities2.get(3));
    }
}
