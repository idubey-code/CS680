package edu.umb.cs680.hw08;

import java.util.LinkedList;

public class FileSystem {
    private LinkedList<Directory> directoryroot;
    private static FileSystem instance = null;

    void appendRootDir(Directory RootDirectory) {
        directoryroot = new LinkedList<Directory>();
        directoryroot.add(RootDirectory);
    }
    private FileSystem() {};

    public static FileSystem getFileSystem() {
        if(instance==null)
            instance = new FileSystem ();
        return instance;
    }

    public LinkedList<Directory> getRootDirs() {
        return this.directoryroot;
    }
    public static void main(String[] args) {
        System.out.println("FileSystem class is run successfully");
    }
}

