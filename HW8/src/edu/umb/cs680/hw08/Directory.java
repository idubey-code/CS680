package edu.umb.cs680.hw08;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class Directory extends FSElement {

    private LinkedList<FSElement> child;

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        if(parent != null)
            parent.appendChild(this);
    }

    public LinkedList<FSElement> getChildren() {
        return child;
    }


    public void appendChild(FSElement child) {
        if(this.child == null) {
            this.child = new LinkedList<FSElement>();
        }
        this.child.add(child);
    }


    public int countChildren() {
        return getChildren().size();
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> directories = new LinkedList<Directory>();
        for(FSElement f : getChildren()) {
            if(f instanceof Directory)
                directories.add((Directory) f);
        }
        return directories;
    }

    public LinkedList<Link> getLinks() {
        LinkedList<Link> linkList = new LinkedList<Link>();
        for(FSElement element : getChildren()) {
            if(element instanceof Link)
                linkList.add((Link) element);
        }
        return linkList;
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<File>();
        for(FSElement f : getChildren()) {
            if(f instanceof File)
                files.add((File) f);
        }
        return files;
    }




    public int getTotalSize() {
        int sizetotal = 0;
        for(FSElement f : getChildren()) {
            if(f instanceof Directory)
                sizetotal += ((Directory) f).getTotalSize();
            else
                sizetotal += f.getSize();
        }
        return sizetotal;
    }


    @Override
    public boolean isDirectory() {
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Directory class is run successfully.");
    }
}

