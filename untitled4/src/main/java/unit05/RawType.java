package main.java.unit05;

import java.util.Arrays;

public class RawType {
    //不使用泛型
    public static void changePosition(int[]arr,int index1,int index2){ //整型数组
        int tem=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=tem;        
    }
    public void changePosition(String[]arr,int index1,int index2){  //字符串数组
        String tem=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=tem;        
    }
    public static void main(String[] args) {
        int[]arr1=new int[]{1,2,3,4,5};
        System.out.println("原数组："+ Arrays.toString(arr1));
        changePosition(arr1,1,3);  //整数数组交换位置；静态方法调用
        System.out.println("交换后："+Arrays.toString(arr1));  //输出数组

        String[]arr2=new String[]{"aa","bb","cc","dd","ee"};
        System.out.println("原数组："+Arrays.toString(arr2));
        new RawType().changePosition(arr2,1,3);  //对字符数组交换位置；非静态方法调用

        System.out.println("交换后："+Arrays.toString(arr2));  //输出数组
    }

    // 定义交换数组中两个元素的泛型方法
/*    public static <T> void changePosition(T[] arr, int index1, int index2) {  //泛型方法
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr1 = new Integer[]{1, 2, 3, 4, 5};  //对象数组
        //int[] arr1=new int[]{1,2,3,4,5}; //调用时会报错，泛型不是值类型
        System.out.println("原数组：" + Arrays.toString(arr1)); // 输出数组
        changePosition(arr1, 1, 3); // 交换位置
        System.out.println("交换后：" + Arrays.toString(arr1)); // 输出数组

        String[] arr2 = new String[]{"aa", "bb", "cc", "dd", "ee"};
        System.out.println("原数组：" + Arrays.toString(arr2)); // 输出数组
        changePosition(arr2, 1, 3); // 交换位置
        System.out.println("交换后：" + Arrays.toString(arr2)); // 输出数组
    }*/

    /*static class ArrayUtils<T> { // 定义静态的泛型类（数组实用工具）
        public void changePosition(T[] arr, int i, int j) { //对换元素，第一参数为对象数组
            T tem = arr[i];
            arr[i] = arr[j];
            arr[j] = tem;
        }
        public void reverse(T[] arr) { //倒序数组
            for (int i = 0; i < arr.length / 2; i++) {
                T tem = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = tem;
            }
        }
    }

    public static void main(String[] args) {
        ArrayUtils<Integer> arrayUtils = new ArrayUtils<Integer>(); //泛型具体化为Integer
        Integer[] arr1 = new Integer[] { 1, 2, 3, 4, 5 };
        System.out.println("原数组："+Arrays.toString(arr1)); // 输出数组
        arrayUtils.reverse(arr1);  //倒排数组
        System.out.println("反转后："+Arrays.toString(arr1)); // 输出数组

        ArrayUtils<String> arrayUtils2 = new ArrayUtils<String>(); //泛型具體化為String
        String[] arr2 = new String[] { "aa", "bb", "cc", "dd", "ee" };
        System.out.println("原数组："+Arrays.toString(arr2)); // 输出数组
        arrayUtils2.changePosition(arr2, 1, 3); // 交换位置
        System.out.println("对换后："+Arrays.toString(arr2)); // 输出数组
    }*/
}