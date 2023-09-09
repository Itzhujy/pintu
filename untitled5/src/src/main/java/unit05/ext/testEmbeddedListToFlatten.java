package src.main.java.unit05.ext;
import java.util.*;
/**
 *  jdk1.8中, 双冒号 :: 叫方法引用是lambda表达式的一个重要特性,它提供了一种不执行方法的方法
 *
 */
class Animal{
    String name;
    boolean yn;
    Animal(String name,boolean yn){
        this.name=name;
        this.yn=yn;
    }
}
public class testEmbeddedListToFlatten {
    public static void main(String[] args) {
        List<List<Animal>> flist=new ArrayList<List<Animal>>();  //新建嵌套List
        List<Animal>  la01=new ArrayList<>();

        //生成嵌套List: List<List<List<Animal>>>
        Animal  a01=new Animal("狮子", false);    //1, 非洲
        la01.add(a01);
        Animal  a02= new Animal("猩猩", true);   //2, 非洲_东南亚
        //List<Animal>  la02=new ArrayList<>();
        la01.add(a02);
        Animal  a03=new Animal("犀牛", true);    //3, 东南亚
        //List<Animal>  la03=new ArrayList<>();
        la01.add(a03);
        Animal  a04=new Animal("大象",true);     //4, 东南亚
        //List<Animal>  la04=new ArrayList<>();
        la01.add(a04);
        Animal  a05=new Animal("羚羊",false);     //5, 非洲
        //List<Animal>  la05=new ArrayList<>();
        la01.add(a05);
        Animal  a06=new Animal("猴子",false);     //6, 亚非美洲
        //List<Animal>  la06=new ArrayList<>();
        la01.add(a06);

        flist.add(la01);
        System.out.println(flist);

        //反之, 由 List<List<...>> 展平到一个List集合
        System.out.println("\n嵌套List集合执行展平>>>");
        List<Animal> pla=new ArrayList<>();
        //List<Animal>[] plist= flist.stream().flatMap(Collection::stream).collect(Collector.toList());
        //test1:
        System.out.println("使用展平1的结果:");
        flist.forEach(pla::addAll);   //jdk1.8 lambda写法
        for(Object ol: pla)
            System.out.println(ol);

        //test2:
        System.out.println("\n使用展平2的结果:");
        List<Animal> pla2=new ArrayList<>();
        Iterator<List<Animal>> itlist= flist.stream().iterator();
        while(itlist.hasNext()) {
            List<Animal> laa = itlist.next();  //.size()
            for (Animal lai : laa) {
                pla2.add(lai);
                System.out.println(lai);
            }
        }
    }
}
