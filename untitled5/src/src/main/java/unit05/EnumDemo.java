package src.main.java.unit05;
/**
 * 使用关键字enum定义作为引用类型且包含约束的枚举类型，隐式地作为抽象类java.lang.Enum的子类
 * Java中的枚举类型，如同C#使用delegate定义委托类型
 * 枚举类型包含若干枚举值，枚举变量赋值只能取枚举值
 * 枚举类型的构造方法不可使用public修饰
 */
enum Week{
    Sun,Mon,Tue,Wed,Thu,Fri,Sat
}
enum Op {   //声明四则运算枚举类型
    Plus('+'), Minus('-'), Multiply('*'), Divide('/');  //枚举值及其描述
    char des;   //定义枚举描述字段

    Op(char des) {  //构造方法，用于实例化枚举描述字段
        this.des = des;
    }

    public char getDes() {  //字段des的getter
        return des;
    }
}

enum Prioirty {   //声明四则运算符优先级的枚举类型
    Lv2(2), Lv1(1), Lv0(0);  //乘除；加减；null
    int des;

    Prioirty(int des) {  //构造方法，用于实例化枚举描述字段
        this.des = des;
    }

    int getDes() {  //字段des的getter
        return des;
    }
}

public class EnumDemo {  //主类
    public static void main(String[] args) {
        System.out.print("一周的各星期：");
        for(Week week:Week.values()){
            System.out.print(week);
            if(week!=Week.Sat){
                System.out.print("  ");
            }
        }
        System.out.println();

        System.out.println("（1）四则运算枚举Op：");
        //遍历所有枚举
        for(Op opVar:Op.values()){
            System.out.print(opVar+"("+opVar.getDes()+")  ");
        }
        System.out.println(" ");
        //枚举的基本用法
        Op op = Op.Divide;  //定义枚举变量op
        System.out.println("Op.Divide属于Enum类型吗？"+( op instanceof Enum));
        System.out.println("Op.Divide="+Op.Divide+"，描述="+op.getDes()+"，序号="+op.ordinal());

        System.out.println("（2）四则运算优先则有枚举Prioirty：");
        for(Prioirty Prioirty:Prioirty.values()){
            System.out.print(Prioirty+"("+Prioirty.getDes()+")  ");
        }
        System.out.println(" ");
    }
}