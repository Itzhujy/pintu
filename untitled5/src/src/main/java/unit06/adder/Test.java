package src.main.java.unit06.adder;

import com.sun.org.apache.xml.internal.security.Init;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Collection<String> cityList=new ArrayList<>();
        cityList.add("aaaa");
        cityList.add("bbbb");
        for (String s : cityList) {
            System.out.println(s);
        }
        Iterator<String> iterator = cityList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
