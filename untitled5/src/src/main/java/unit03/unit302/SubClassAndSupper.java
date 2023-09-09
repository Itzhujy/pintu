package src.main.java.unit03.unit302;

/**
 * 继承抽象类的类，必须重写抽象类的抽象方法
 * 实现接口的类，必须重写接口定义的（抽象）方法
 * =================================================
 * 非直接子类（隔代）的方法重写：
 *（1）抽象类继承抽象类或抽象类抽象实现接口
 *（2）抽象类实现接口或继承抽象类，不要求实现接口方法或覆盖基类方法
 */
interface ListAdapter{
    int getCount();
}
abstract class BaseAdapter implements ListAdapter{
    public void mm(){
        System.out.println("这是抽象类定义的具体方法。");
    }
}
public class SubClassAndSupper {   //测试类
    public static void main(String[] args) {
        BaseAdapter obj=new BaseAdapter() {
            @Override
            public int getCount() {
                return 0;
            }
        };
        System.out.println(obj.getCount());
        obj.mm();
    }
}
