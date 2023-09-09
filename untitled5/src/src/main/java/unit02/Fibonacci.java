package src.main.java.unit02;

import org.junit.Test;

/**
 * 使用一维数据，输出 Fibonacci 数列的前 20 项
 * 要求：每行输出5个数，宽度为10，左对齐
 * 与c语言类似，格式符中的减号表示左对齐，省略时右对齐。
 */
public class Fibonacci {    //使用数组
    public static void main(String[] args) {
        int n=20;
        int[] a= new int[n];  //定义整型数组
        a[0]=a[1]=1;  //初始化数列最前面的2个元素
        for(int i=2;i<a.length;i++){
            a[i]=a[i-1]+a[i-2];
        }
        for(int i=0;i<a.length;i++) {
            System.out.printf("%-10d", a[i]);
            //System.out.printf(String.format("%-10d", a[i]));
            if((i+1)%5==0) System.out.println();
        }
    }

    @Test
    public void fibonacci2(){   //使用简单变量
        int a=1,b=1,c;
        System.out.printf("%-10d%-10d", a,b);  //输出前2项
        for(int i=2;i<20;i++) {
            c=a+b;
            a=b;
            b=c;
            System.out.printf("%-10d", c);   //printf与c语言类似
            if((i+1)%5==0) System.out.println();
        }
    }

    @Test
    public void fibonacci3(){   //调用递归方法
        for(int i=0;i<20;i++) {
            System.out.printf("%-10d", fib(i));
            if((i+1)%5==0) System.out.println();  //控制输出格式
        }
    }
    public int fib(int n) {  //定义递归方法
        if(n==0||n==1){
            return 1;   //递归结束条件
        } else{
            return fib(n-1)+fib(n-2);  //递归调用
        }
    }
}
