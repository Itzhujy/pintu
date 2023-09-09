package src.main.java.unit05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;  //姓名
    private String gender;  //性别
    private int age; //年龄
}
