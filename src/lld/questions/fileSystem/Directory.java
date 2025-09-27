package lld.questions.fileSystem;

import java.util.*;

interface DirectoryInterface {
    public String getName();
    public Map<String, DirectoryInterface> getSubDirectories();
    public void addSubDirectory(String name);
    public DirectoryInterface getParent();
}
public class Directory implements DirectoryInterface {
    private String name;
    private Map<String, DirectoryInterface> subDirectories;
    private DirectoryInterface parent;

    public Directory(String name, DirectoryInterface parent) {
        this.name = name;
        subDirectories = new HashMap<>();
        this.parent = parent;
    }
    public String getName() {
        return name;
    }
    public Map<String, DirectoryInterface> getSubDirectories() {
        return subDirectories;
    }
    public void addSubDirectory(String name) {
        DirectoryInterface subDirectory = new Directory(name, this);
        subDirectories.put(name, subDirectory);
    }
    public DirectoryInterface getParent() {
        return parent;
    }
}

class FileSystem {
    DirectoryInterface currentDirectory;
    DirectoryInterface rootDirectory;

    public FileSystem() {
        currentDirectory = new Directory("/", null);
        rootDirectory = currentDirectory;
    }
    public void cwd(){

        DirectoryInterface tempDirectory = currentDirectory;
        String path = "";
        while (tempDirectory != null) {
            path = tempDirectory.getName() + "/" + path;
            tempDirectory = tempDirectory.getParent();
        }
        System.out.println(path.substring(1));

    }
    public void mkdir(String path){
        if(path.equals("/")){
            System.out.println("Directory: "+ path+" already exists");
            return;
        }
        DirectoryInterface tempDirectory = this.currentDirectory;
        if(path.startsWith("/")){
            tempDirectory = rootDirectory;
            path = path.substring(1);
        }
        String[] dirs = path.split("/");
        for(int i=0;i<dirs.length-1;i++){
            String currDir = dirs[i];
            tempDirectory = tempDirectory.getSubDirectories().getOrDefault(currDir, null);
            if(tempDirectory == null){
                System.out.println("Path: "+ path+" does not exists");
                return;
            }

        }
        String newSubDir = dirs[dirs.length-1];
        if(tempDirectory.getSubDirectories().containsKey(newSubDir)){
            System.out.println("Directory: "+ newSubDir+" already exists");
            return;
        }
        tempDirectory.addSubDirectory(newSubDir);
        System.out.println("Directory: "+ newSubDir+" created");
    }
    public void cd(String path){
        if(path.equals("/")){
            currentDirectory = rootDirectory;
            return;
        }
        DirectoryInterface tempDirectory = this.currentDirectory;
        if(path.startsWith("/")){
            tempDirectory = rootDirectory;
            path = path.substring(1);
        }
        String[] dirs = path.split("/");
        for(int i=0;i<dirs.length;i++){
            String currDir = dirs[i];
            tempDirectory = tempDirectory.getSubDirectories().getOrDefault(currDir, null);
            if(tempDirectory == null){
                System.out.println("Path: "+ path+" does not exists");
                return;
            }
        }
        this.currentDirectory = tempDirectory;
    }

    public void ls(){
        System.out.println("Printing all the subdirectories");
        for(DirectoryInterface subDirectory : currentDirectory.getSubDirectories().values()){
            System.out.println(subDirectory.getName());
        }
    }

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        fs.cwd();
        fs.mkdir("Users");
        fs.mkdir("Users/User1");
        fs.mkdir("Users/User2");
        fs.cd("Users");
        fs.cwd();
        fs.ls();

        fs.cd("Users3");

        fs.cd("/Users/User1");
        fs.cwd();

        fs.mkdir("/Users/User2");
        fs.cwd();


        fs.mkdir("/Users/User3");
        fs.cwd();

        fs.cd("/Users");
        fs.cwd();

        fs.cd("User3");
        fs.cwd();

        fs.mkdir("Nitin");
        fs.cd("Nitin");
        fs.cwd();

        fs.cd("/");
        fs.cwd();

        fs.mkdir("/");
        fs.cwd();

    }

}
