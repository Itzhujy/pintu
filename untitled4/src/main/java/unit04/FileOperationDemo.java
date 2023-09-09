package main.java.unit04;
import java.io.File;
/**
 * 预备：在硬盘上创建一个文件夹media，其内包含一些.txt或.docx的文件，
 * 还包含存放若干图片的文件夹image和存放若干音乐的文件夹music。
 * 使用透明组合模式，一致地看待文件与目录，使用类java.io.File表示文件或目录。
 */
public class FileOperationDemo {
    //创建拟操作的目录对象，作为类的静态成员
    static File directory=new File("d:/media");

    public static void main(String[] args) throws Exception{
        //1. 在指定目录创建一个以wzx打头、临时的文本文件
        File.createTempFile("wzx",".txt",directory);
        //运行后查看

        //2.目录及其子目录的遍历
        listDirectory(directory);
    }

    //文件列表（递归方法）
    public static void listDirectory(File directory){
        File[] files = directory.listFiles();  //获取指定目录下的文件和子目录
        for (File file:files) {  //遍历
            System.out.println(file.getAbsolutePath());  //输出文件名
            if(file.isDirectory()){  //如果是目录
                System.out.println("-------------------");
                listDirectory(file);  //递归调用
            }
        }
    }
}
