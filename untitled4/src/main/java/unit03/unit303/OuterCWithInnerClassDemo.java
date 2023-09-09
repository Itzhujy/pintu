package main.java.unit03.unit303;

public class OuterCWithInnerClassDemo {  //含有内部类的外部类示例
    private int num=2;
    private void addOneNum(){  //私有方法；加 1并输出
        num++;
        System.out.println("num="+num);
    }
    private class InnerClass{  //私有内部类
        void getOneNum(){  //减 1并输出
            num--;
            System.out.println(num);
        }
        void putOneNum(){
            addOneNum();  //调用外部类的私有方法
        }
    }
    public void visitPrivateMembersByInnerClass(){
        System.out.println(num);  //输出：2
        InnerClass innerClass = new InnerClass();  //创建内部类对象
        innerClass.getOneNum();  //输出：1
        innerClass.putOneNum();  //输出：num=2
    }

    public static void main(String[] args) {
        new OuterCWithInnerClassDemo().visitPrivateMembersByInnerClass();
    }
}
