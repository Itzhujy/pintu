package src.main.java.unit05;

import java.util.TreeMap;

/**
 * TreeMap类：
 *    TreeMap是一个能比较元素大小的Map集合，会对传入的key进行了大小排序。
 *    可以使用元素的自然顺序，也可以使用集合中自定义的比较器来进行排序
 * R类：
 *    重写equals(Object obj)，value属性值相等时，返回true
 *    重写了compareTo(Object obj)，value属性值相等时，返回0
 */
class R implements Comparable {
    int value;

    public R(int value) {
        this.value = value;
    }

    public String toString() {
        return "R(value属性:" + value + ")";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == R.class) {
            R r = (R) obj;
            if (r.value == this.value) {
                return true;
            }
        }
        return false;
    }

    public int compareTo(Object obj) {
        R r = (R) obj;
        if (this.value > r.value) {
            return 1;
        } else if (this.value == r.value) {
            return 0;
        } else {
            return -1;
        }
    }
}

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap tm = new TreeMap();
        tm.put(new R(3), "Key值为3的value");
        tm.put(new R(-5), "Key值为-5的value");
        tm.put(new R(9), "Key值为9的value");
        System.out.println("TreeMap集合中的所有元素：\n" + tm);
        // 返回该TreeMap的第一个Entry对象
        System.out.println("\n第一个Entry对象：" + tm.firstEntry());
        // 返回该TreeMap的最后一个key值
        System.out.println("最后一个key值:" + tm.lastKey());
        // 返回该TreeMap的比new R(2)大的最小key值。
        System.out.println("比new R(2)大的最小key值:" + tm.higherKey(new R(2)));
        // 返回该TreeMap的比new R(2)小的最大的key－value对。
        System.out.println("比new R(2)小的最大的key－value对:" + tm.lowerEntry(new R(2)));
        // 返回该TreeMap的子TreeMap
        System.out.println("该TreeMap的子TreeMap:" + tm.subMap(new R(-1), new R(4)));
    }
}
