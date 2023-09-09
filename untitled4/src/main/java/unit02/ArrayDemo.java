package main.java.unit02;

public class ArrayDemo {
    public static void main(String[] args) {
        //定义数组并初始化
        int[] fibnacci=new int[20];
        fibnacci[0]=1;
        fibnacci[1]=1;

        //递推计算
        for(int i=2;i<20;i++){
            fibnacci[i]=fibnacci[i-1]+fibnacci[i-2];
        }

        //格式化输出
        for(int i=0;i<20;i++){
            System.out.printf("%-5d",fibnacci[i]);
            //System.out.format("%5d",fibnacci[i]);
            if((i+1)%5==0){   //数组下标从0开始
                System.out.println();
            }
        }
    }
}
