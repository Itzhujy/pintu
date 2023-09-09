package src.main.java.unit02;

import java.util.Collections;

public class ArrayMenuDemo {
    public static void main(String[] args) {
        String[] menuArr={"文件","编辑","查看","颜色","帮助"};
        String[][] menuItemArr = {{"新建","打开","保存","退出"},{"撤销","恢复"},{"工具箱","颜料盒"},{"编辑"},{"说明","关于"}};
        //输出主菜单
        for (int i = 0; i < menuArr.length; i++) {
            if(i > 0){
                System.out.printf("\t");  //添加制表符
            }
            System.out.printf("%-5s", menuArr[i]);  //输出主菜单
        }
        System.out.println();
        System.out.println(String.join("", Collections.nCopies(40,"-")));
        //计算子菜单项的最大值 maxRow
        int maxRow=0;
        for(int i=0;i< menuArr.length; i++){
            if(menuItemArr[i].length>maxRow){
                maxRow=menuItemArr[i].length;
            }
        }
        //输出菜单项
        for (int i = 0; i < maxRow; i++) {  //最多maxRow行
            for (int j = 0; j < menuArr.length; j++) {
                if(j > 0){
                    System.out.printf("\t");  //添加制表符
                }
                if(j<menuArr.length && i<menuItemArr[j].length){
                    System.out.printf("%-5s", menuItemArr[j][i]);
                }else{
                    System.out.printf("%-5s", "");  //无菜单项时补空
                }
            }
            System.out.println();
        }
    }
}