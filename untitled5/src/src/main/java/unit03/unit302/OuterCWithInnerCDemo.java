package src.main.java.unit03.unit302;

/**
 * 定义包含内部类作为成员的内部类
 * 通过内部类对象，访问和操作外部类的私有属性和方法
 */
class OuterCWithInnerC{
    private int num = 2;

    private void addOneNum() {
        num++;
        System.out.println("num=" + num);
    }

    class InnerC {   //内部类
        void getOneNum() {
            num--;
            System.out.println("num=" + num);
        }

        void putOneNum() {
            addOneNum();
        }
    }

    public void visitPrivateMemberByInnerClass() {
        System.out.println("num初值="+num);
        InnerC innerC = new InnerC();
        //通过内部类对象调用外部的私有方法
        innerC.getOneNum();
        innerC.putOneNum();
    }
}

public class OuterCWithInnerCDemo{  //测试类
    public static void main(String[] args) {
        //创建外部类的实例
        OuterCWithInnerC outerCWithInnerC = new OuterCWithInnerC();
        //调用外部类的实例方法
        outerCWithInnerC.visitPrivateMemberByInnerClass();
        //创建内部类的实例
        OuterCWithInnerC.InnerC innerC = outerCWithInnerC.new InnerC();
        //调用内部类的实例方法
        innerC.getOneNum();
        innerC.putOneNum();
    }
}
