package main.java.unit05;
/**
 * 使用枚举类型
 * 模拟交通信号灯的变化过程
 */
enum Signal {  //定义一个枚举类型
    GREEN, YELLOW, RED    //枚举成员
}

public class TrafficLight {  //测试类
    public Signal lightChange(Signal color) {  //模拟交通信号灯的变化过程
        switch (color) {
            case RED:
                return Signal.GREEN;
            case GREEN:
                return Signal.YELLOW;
            case YELLOW:
                return Signal.RED;
        }
        return null;
    }

    public static void main(String[] args) {
        for (int i = 0; i < Signal.values().length; i++) {
            System.out.println("枚举成员：" + Signal.values()[i]);
        }
        TrafficLight trafficLight = new TrafficLight();
        System.out.println();
        System.out.print("信号灯变化过程："+Signal.GREEN);
        System.out.print("-->"+trafficLight.lightChange(Signal.GREEN));
        System.out.print("-->"+trafficLight.lightChange(Signal.YELLOW));
        System.out.print("-->"+trafficLight.lightChange(Signal.RED));
        System.out.println("...");
    }
}