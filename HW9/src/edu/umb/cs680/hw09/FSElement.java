package edu.umb.cs680.hw09;

import java.time.LocalDateTime;

public abstract class FSElement {
    private String name;
    private int size;
    private LocalDateTime creationTime;
    private APFSDirectory parent;
    public int getSize() {
        return size;
    }
    public FSElement(APFSDirectory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }


    public String getName() {
        return name;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public APFSDirectory getParent() {
        return parent;
    }
    public abstract boolean isDirectory();

    public static void main(String[] args) {
        System.out.println("FSElement run successfully");
    }
}
