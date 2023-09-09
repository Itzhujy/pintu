package main.java.unit05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class RawTypeClassDemo {
    static class ArrayUtils<T> { // 定义静态的泛型类（数组实用工具）
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
        System.out.println("原数组："+ Arrays.toString(arr1)); // 输出数组
        arrayUtils.reverse(arr1);  //倒排数组
        System.out.println("反转后："+Arrays.toString(arr1)); // 输出数组
    
        ArrayUtils<String> arrayUtils2 = new ArrayUtils<String>(); //泛型具體化為String
        String[] arr2 = new String[] { "aa", "bb", "cc", "dd", "ee" };
        System.out.println("原数组："+Arrays.toString(arr2)); // 输出数组
        arrayUtils2.changePosition(arr2, 1, 3); // 交换位置
        System.out.println("对换后："+Arrays.toString(arr2)); // 输出数组
    }
}