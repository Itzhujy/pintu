package main.java.unit05;
import java.util.Iterator;
/**
 * 研究JDK提供的可迭代接口java.lang.Iterable和迭代器接口 java.util.Iterator的使用
 * 定义实现可迭代接口 Iterable 的类ArrayStack
 * 使用数组模拟栈的压入和弹出操作
 * 程序里的数组大小为100，可修改为5
 */
class ArrayStack<T> implements Iterable<T> {   //自定义泛型类
    //定义2个成员字段
    private T[] arr = (T[]) new Object[100];  //泛型数组
    private int size = 0;  //计数实际存放的数据个数

    //模拟堆栈操作的2个方法push()和pop()
    public void push(T item) {  //存放数据至数组
        arr[size++] = item;
    }
    public T pop() {  //从数组取出数据
        return arr[--size];
    }

    @Override
    public Iterator<T> iterator() {  //实现接口方法
        return new ArrayIterator();  //返回一个迭代器对象
    }

    //自定义实现接口 Iterator的迭代器，作为内部类
    private class ArrayIterator implements Iterator<T> {
        private int i = 0;

        @Override
        public boolean hasNext() { //必须实现的接口方法
            return i < size;
        }

        @Override
        public T next() {  //必须实现的接口方法
            return arr[i++];
        }

        @Override
        public void remove() {   //非必须实现的接口方法，参见接口Iterator的源码
            throw new UnsupportedOperationException();
        }
    }
}

public class IterableAndIteratorDemo {  //测试类
    public static void main(String[] args) {
        //创建自定义的集合对象
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        //添加数据至数组
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
        }
        //输出数组元素
        System.out.print(arrayStack.pop());
        Iterator iterator = arrayStack.iterator();  //创建迭代器对象
        //使用动态调试，可验证iterator包含arrayStack的数据信息
        while (iterator.hasNext()) {
            System.out.print(" " + iterator.next());
        }
        System.out.println();

        ArrayStack<String> strArray = new ArrayStack<>();
        strArray.push("Java");
        strArray.push("C#");
        strArray.push("C++");
        Iterator it = strArray.iterator();
        while (it.hasNext()) {
            System.out.print(it.next()+" ");
        }
    }
}
