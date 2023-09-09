package src.main.java.unit06;

import javax.swing.*;

/*
 * 类JOptionPane提供了多种对话框的使用
 * 下面的三种对话框属于强制型，用户不能中断对话过程，直至对话框结束
*/
public class SwingDialogDemo {
	public static void main(String[] args) {
		String name;
		int selection;

		do {
			name = JOptionPane.showInputDialog("请输入姓名："); 	//输入对话框

			//是否型对话框
			selection = JOptionPane.showConfirmDialog(
					null, //父组件
					"你的姓名是 " + name + "?",
					"请确认",
                   	//下面的类常量可换成YES_NO_CANCEL_OPTION
					JOptionPane.YES_NO_OPTION
			);
		} while (selection != JOptionPane.YES_OPTION);  //直到选择Yes

		JOptionPane.showMessageDialog(null, "你的姓名是" + name); 	//消息确认框
	}
}
