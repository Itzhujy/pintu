package src.main.java.unit03.unit301;

class Staff {  //基类
	//属性定义为包访问权限或protected，子类就可以访问。定义为private，子类则不能访问。
    String name;
    int salary;

	public String getName() {  //实体类属性name的getter
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public Staff(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getDetails() {
        return "Name："+name+"---Salary："+salary;
    }
}

public class Manager extends Staff {   //子类
    String department;

	public Manager(String name, int salary,String department) {
		super(name, salary);
		this.department=department;
	}

	@Override   //重写基类方法
	public String getDetails() {
		return "Name:"+name+"\nSalary："+salary+"\nManager of "+department;
	}

    public static void main(String[] args) {
		System.out.println(new Staff("张三", 9000).getDetails());
		Manager manager = new Manager("李四", 12000, "人力资源部");
		System.out.println(manager.getDetails());
	}
}
