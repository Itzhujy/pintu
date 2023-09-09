package main.java.unit03.unit301.ks;

class Car {
    String carNumber;

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    void showCarNumber() {
        System.out.println("我的车牌号是:"+carNumber);
    }
}

public class CarDemo {
    public static void main(String args[]) {
        Car car = new Car();
        car.setCarNumber("粤CA299F");
        car.showCarNumber();
    }
}
