package main.java.unit06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 本窗体供登录窗体调用，也可以单独使用
 */
public class MainFrame extends JFrame {
	public static String userName;  //为简化类 MessageClient 对本字段的访问, 使用public

	public static void main(String[] args) {
		new MainFrame("");  //直接运行主窗体
	}

	public MainFrame(String userName) {  //有参构造方法
		this.userName = userName;  //建立类的公有静态属性，以供其它对象框调用
		if("".equals(userName)){   //便于不经过登录窗体而直接运行本窗体
			setTitle("公司人力资源管理系统");
		}else{
			setTitle("公司人力资源管理系统-" + userName);
		}
		Dimension screenSize=getToolkit().getScreenSize();  //获取屏幕大小
		setSize(new Dimension((int)screenSize.getWidth()/2, (int)screenSize.getHeight()/2));
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		createMenuBar();  //创建菜单
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void createMenuBar() {  //为窗体创建菜单并监听菜单项
		JMenuBar menuBar = new JMenuBar();
		String[] menuArr={"用户管理","员工信息管理","工资信息查询","在线交流","系统"};
		String[][] menuItemArr = {{"用户管理"},{"基本信息管理","工资信息管理"},{"工资信息查询"},{"在线交流"},{"注销","退出"}};
		for (int i = 0; i < menuArr.length; i++) {
			JMenu menu = new JMenu(menuArr[i]);  //创建菜单项
			for (int j = 0; j < menuItemArr[i].length; j++) {
				JMenuItem menuItem = new JMenuItem(menuItemArr[i][j]);  //新建菜单项
				menu.add(menuItem);  //添加菜单项至菜单
				String menuName = menuItemArr[i][j];  //获取菜单项名称
				menuItem.addActionListener(new ActionListener() {  //菜单项单击监听
					@Override
					public void actionPerformed(ActionEvent e) {
						menuOperation(menuName);
					}
				});
			}
			menuBar.add(menu);  //添加菜单至菜单栏
		}
		setJMenuBar(menuBar);  //为窗体添加 JMenubar
		//未登录时，设置菜单项【注销】不可用
		if("".equals(userName)) getJMenuBar().getMenu(4).getItem(0).setEnabled(false);
	}

	private void menuOperation(String menuName) {  //供菜单项监听器调用
		switch (menuName) {
			case "退出":
				System.exit(0);   //退出应用程序
			case "注销":
				dispose();  //销毁当前窗体
				new SwingUIDemo();
				break;
			default:
				String msg = "你选择了待完成的【" + menuName + "】功能";
				JOptionPane.showMessageDialog(this, msg);
		}
	}
}
