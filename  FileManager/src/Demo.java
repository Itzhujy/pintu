import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//定义一个具体的可操作文件
        Files oneFile=new Files();
        //定义一个接受盘符对象的集合
        ArrayList<Drive> arrayList = new ArrayList<>();
        //定义一个存文件的数组
        File [] arrayFile=new File[]{};
        //定义一个存文件的集合
        ArrayList<Files> filesArrayList = new ArrayList<>();
        Drive panFu = new Drive();
        Files files = new Files();
        //遍历盘符
        arrayList= Drive.DriveSelect();
        System.out.println(arrayList);
        //查询盘符
        arrayFile=files.allFileSelect(arrayList);
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入你想进入的盘符");
//       int x= scanner.nextInt();
//       for (PanFu panFu1:arrayList){
//           if (x==panFu1.getId()){
//               System.out.println(panFu1.getId());
//               File file = new File(panFu1.getName());
//               for (File listFile : file.listFiles()) {
//                   System.out.println(listFile);
//               }
//
//           }

        //遍历文件的方法
        filesArrayList=  files.intoFile(arrayFile);
//        System.out.println("请输入你想进入的文件");
//        int i = scanner.nextInt();
//        for (Files files1:filesArrayList){
//            if (files1.getId()==i){
//
//            }
//        }
        //获取具体文件的方法
        oneFile= files.getfile(filesArrayList);
        //进行操作文件的方法
        System.out.println(1+"重命名"+"\t"+2+"移动"+"\t"+3+"删除"+"\t"+4+"获取文件信息"+"\t"+5+"返回"+"\t");
        int i = scanner.nextInt();
        Scanner str=   new Scanner(System.in);
        switch (i){
            case 1:
                System.out.println(i+"请输入重命名");

                String s=str.next();
                files.rename(oneFile,s);
                System.out.println("重命名为"+s);
                break;
            case 2:
                System.out.println("请输入移动的位置");
                String s2=str.next();
                files.rename(oneFile,s2);
                System.out.println(i+"移动");

                break;
            case 3:
                System.out.println(i+"删除");
                files.delete(oneFile);
               System.out.println(files);
                break;
            case 4:
                System.out.println(i+"获取文件信息（文件路径，大小，可读，可写）");
                files.getMessageOfFile(oneFile);
                break;
            case 5:
                System.out.println(i+"返回(继续显示当前所有的文件及目录)");
                files.backForm(oneFile);
                break;
        }
    }

}