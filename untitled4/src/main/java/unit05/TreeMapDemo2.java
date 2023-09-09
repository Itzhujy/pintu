package main.java.unit05;

import java.util.Collection;
import java.util.TreeMap;

@Data
@AllArgsConstructor
/**
 * TreeMap是一个能比较元素大小的Map集合，会对传入的key进行大小排序。
 */
class Student {   //实体类
    String name;
    int score;

    public Student(String k, int i) {
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }
}
public class TreeMapDemo2 {
    Student[] stu=new Student[30];  //对象数组

    public static void main(String[] args) {
        TreeMapDemo2 tm = new TreeMapDemo2();
        tm.stu[0] = new Student("zs",80);
        tm.stu[1] = new Student( "ls",70);
        tm.stu[2] = new Student("ww",90);

        TreeMap<Integer, Student> treemap = new TreeMap();
        treemap.put(Integer.valueOf(1), tm.stu[2]);
        treemap.put(Integer.valueOf(2), tm.stu[0]);
        treemap.put(Integer.valueOf(3), tm.stu[1]);

        Collection<Student> allStu = treemap.values();
        System.out.println("学生成绩排序如下：");
        for (Student cs : allStu) {    //遍历
            System.out.println("学生姓名：" + cs.getName()+"/成绩：" + cs.getScore());
        }
    }
}
