import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Files {
    private String name;
    private int id;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
   @Override
    public String toString(){
        return "Files{"+"name='" + name + '\'' + ",id=" + id + '}';
    }
    public File[] allFileSelect(ArrayList<Drive> arrayList){
        Scanner scanner = new Scanner(System.in);
        File[] fff = new File[]{};
        System.out.println("请输入你想进入的盘符");
        int x = scanner.nextInt();
        for(Drive drive1: arrayList){
            if(x==drive1.getId()){
                System.out.println(drive1.getId());
                File file = new File(drive1.getName());
                File[] files = file.listFiles();
                return files;
            }

        }
        return fff;
    }
    public ArrayList<Files> intoFile(File[] files){
        ArrayList<Files> files2 = new ArrayList<>();
        int id = 1;
        for(File file :files){
            Files files1 = new Files();
            files1.setId(id);
            files1.setName(file.toString());
            System.out.println(files1.getId());
            System.out.println(files1.getName());
            files2.add(files1);
            id++;
        }
        return files2;
    }
    public Files getfile(ArrayList<Files> filesArrayList){
        Files files = new Files();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你想进入的文件");
        int i = scanner.nextInt();
        for(Files files1 : filesArrayList){
            if(i==files1.getId()){
                return files1;
            }

        }
        System.out.println("未找到");
        return files;
    }
    public void rename(Files oneFile,String s){
        File file = new File(oneFile.getName());
        file.renameTo(new File(s));
    }
    public void getMessageOfFile(Files oneFile){
        File file = new File(oneFile.getName());
        System.out.println("该文件的决定路径为"+file.getAbsolutePath());
        System.out.println("是否可以阅读"+file.canRead());
        System.out.println("是否可以写"+file.canWrite());
        System.out.println("文件的长度"+file.length());

    }
    public void delete(Files oneFile){
        File file = new File(oneFile.getName());
        file.delete();
        System.out.println(file);
    }
    public void backForm(Files oneFile){
        File file = new File(oneFile.getName());
        String str = file.toString().charAt(0)+":";
        File file1 = new File(str);
        for(File listFile : file1.listFiles()){
            System.out.println(listFile);
        }
    }
}
