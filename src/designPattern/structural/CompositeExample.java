package designPattern.structural;

import java.util.ArrayList;
import java.util.List;
// common interface for both leaf and composite class
interface FileSystem {
    void ls();
    void add(FileSystem file);
    void remove(FileSystem file);
}
// left object will do actual work
class File implements FileSystem {
    String name;

    public File(String name) {
        this.name = name;
    }
    @Override
    public void ls(){
        System.out.println("File name is: "+this.name);
    }
    @Override
    public void add(FileSystem file) {
        throw new UnsupportedOperationException("Can not add file to file");
    }
    @Override
    public void remove(FileSystem file) {
        throw new UnsupportedOperationException("Can not remove file from file");
    }
}
// composite have a list of other subcompsite and deligate its work to them
class Directory implements FileSystem {
    String name;

    List<FileSystem> dirList = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }
    public void add(FileSystem file){
        dirList.add(file);
    }
    public void remove(FileSystem file){
        dirList.remove(file);
    }
    @Override
    public void ls() {
        System.out.println("Directory name is: "+this.name);
        for(FileSystem file : dirList){
            file.ls();
        }
    }
}
public class CompositeExample {

    public static void main(String[] args) {
        FileSystem root = new Directory("root");
        FileSystem dir1 = new Directory("dir1");
        FileSystem file1 = new File("file1");
        FileSystem file2 = new File("file2");
        FileSystem file3 = new File("file3");
        root.add(file1);
        root.add(dir1);
        dir1.add(file2);
        dir1.add(file3);

        root.ls();

    }
}
