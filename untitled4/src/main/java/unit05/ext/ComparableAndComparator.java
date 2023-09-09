package main.java.unit05.ext;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Java中，包装器类型都实现了各自的 compareTo(<? super Object>)方法。List实现类则实现了sort(Comparator<? super E> c)排序方法。
 * 使用Collections的sort(List<T> list)方法排序集合时，集合元素必须实现Comparable接口并且定义比较规则。对于多个不同的比较规则会带来一些麻烦。
 * 而Collections重载的sort(List<T> list, Comparator<? super T> c)方法(或Arrays.sort(Object[]))允许传入一个外部的比较器，
 * 该方法不再要求集合元素必须实现Comparable接口，并且不再使用集合元素自身的比较规则排序了，而是根据给定的这个外部的比较器的比较规则,对集合元素进行排序。
 * 如果集合元素是自定义的，创建比较器时经常使用匿名内部类的形式，因此代码扩展性好。
 *
 */

class Person {
    Integer age;
    String name;
    String sex;

    Person(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex=sex;
    }

    @Override
    public String toString() {
        return String.format("name=%s, age=%d, sex=%s", name, age, sex);
    }
}

public class ComparableAndComparator {

    public static void main(String[] args) {
        CompareA();
        CompareB();
    }

    /**
     * Collections.sort方法测试
     */
    private static void CompareA() {
        List<Person> persons = Arrays.asList(new Person("zhangSan",35,"男"),new Person("liSi",50,"女"),new Person("wangEr",40,"男"));
        // 使用匿名内部类进行排序
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {  //Object
                if(o1.age !=o2.age)
                    //return o1.age- o2.age;
                    return Integer.compare(o1.age, o2.age);
                else if (!o1.name.equals(o2.name))
                    return o1.name.compareTo(o2.name);
                else
                    return o1.sex.compareTo(o2.sex);
            }
        });
        System.out.println(persons);
    }

    /**
     * 使用List自带的排序方法
     */
    private static void CompareB() {
        List<Person> persons2 = Arrays.asList(new Person("zhangSan",35,"男"),new Person("liSi",50,"女"),new Person("wangEr",40,"男"));
        persons2.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {  //Object
                if(o1.age !=o2.age)
                    //return o1.age- o2.age;
                    return Integer.compare(o1.age, o2.age);
                else if (!o1.name.equals(o2.name))
                    return o1.name.compareTo(o2.name);
                else
                    return o1.sex.compareTo(o2.sex);
            }
        });
        System.out.println(persons2);
    }
}

