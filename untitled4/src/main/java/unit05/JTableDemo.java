package main.java.unit05; /**
 * 使用JTable控件显示二维表数据（静态数据）
 * 显示数据库表的内容（动态数据），参见第9章
 */

import javax.swing.*;
import java.awt.*;

public class JTableDemo {
    public static void main(String[] args) {
        //定义表头栏目
        final Object[] columnNames = {"姓名", "性别", "家庭地址", "电话号码", "生日", "工作", "收入", "婚姻状况", "恋爱状况"};
        //定义表格数据
        Object[][] rowData = {
                {"ddd", "男", "江苏南京", "1378313210", "03/24/1985", "学生", "寄生中", "未婚", "没"},
                {"eee", "女", "江苏南京", "13645181705", "xx/xx/1985", "家教", "未知", "未婚", "好象没"},
                {"fff", "男", "江苏南京", "13585331486", "12/08/1985", "汽车推销员", "不确定", "未婚", "有"},
                {"ggg", "女", "江苏南京", "81513779", "xx/xx/1986", "宾馆服务员", "确定但未知", "未婚", "有"},
                {"hhh", "男", "江苏南京", "13651545936", "xx/xx/1985", "学生", "流放中", "未婚", "无数次分手后没有"}
        };
        //创建 JTable对象，并设置相关属性
        JTable jTable = new JTable(rowData, columnNames);
        jTable.setPreferredScrollableViewportSize(new Dimension(600, 100));//设置表格的大小
        jTable.setRowHeight(30);//设置每行的高度为20
        jTable.setRowHeight(0, 20);//设置第1行的高度为15
        jTable.setRowMargin(5);//设置相邻两行单元格的距离
        jTable.setRowSelectionAllowed(true);//设置可否被选择.默认为false
        jTable.setSelectionBackground(Color.white);//设置所选择行的背景色
        jTable.setSelectionForeground(Color.red);//设置所选择行的前景色
        jTable.setGridColor(Color.black);//设置网格线的颜色
        jTable.selectAll();  //选择所有行
        jTable.setRowSelectionInterval(0, 2);//设置初始的选择行,这里是1到3行都处于选择状态
        jTable.clearSelection();//取消选择
        jTable.setDragEnabled(false);
        jTable.setShowGrid(true);   //是否显示网格线
        jTable.setValueAt("tt", 0, 0); //设置某个单元格的值
        jTable.setBackground(Color.lightGray);   //设置表格背景色
        //创建与JTable相适应的可滚动面板
        JScrollPane jScrollPane = new JScrollPane(jTable);
        //创建普通面板并设置相关属性
        JPanel jPanel = new JPanel(new GridLayout(0, 1));
        jPanel.setPreferredSize(new Dimension(600, 100));
        jPanel.setBackground(Color.black);
        //添加可滚动面板至普通面板
        jPanel.add(jScrollPane);

        JFrame jFrame = new JFrame("JTableDemo");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setContentPane(jPanel);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}


