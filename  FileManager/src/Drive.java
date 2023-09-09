import java.io.File;
import java.util.ArrayList;

public class Drive {
    private   String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString(){
        return "Files{"+"name='" + name + '\'' + ",id=" + id + '}';
    }
    public static ArrayList<Drive> DriveSelect(){
        File[] files = File.listRoots();
        ArrayList<Drive> arrayList = new ArrayList<>();
        int i = 1;
        for(File file : files){
            Drive drive = new Drive();
            drive.setName(file.toString());
            drive.setId(i);
            System.out.println(drive.getId());
            System.out.println(file);
            arrayList.add(drive);
            i++;
        }
        return arrayList;
    }


}
