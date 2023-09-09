package src.main.java.unit02;
import java.util.Calendar;
import java.util.Date;

/**
 * JDK类库，提供了多种获取时间戳的方法
 * 要点：静态方法与实例方法。
 *      静态方法的m图标的左下方有一个灰色的菱形，而实例方法没有灰色的菱形。
 */
public class DateAndTimeDemo {  //时间戳
    public static void main(String[] args) {
        //Date是普通类，具有无参构造方法，getTime()是实例方法
        System.out.println(new Date().getTime());

        //Calendar是抽象类，getInstance()是它的抽象方法，用于实例化，getTimeInMillis()是实例方法
        System.out.println(Calendar.getInstance().getTimeInMillis());
        //new Calendar()  //抽象类不能直接使用无参构造方法实例化对象。否则，需要重写未实现的所有方法

        //使用类System的静态方法currentTimeMillis()
        System.out.println(System.currentTimeMillis());
    }
}
