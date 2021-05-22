package edu.umb.cs680.hw09;

import java.time.LocalDateTime;

public class APFSFile extends APFSElement{

    public APFSFile(APFSDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName, LocalDateTime lastModified) {
        super(parent, name, size, creationTime, ownerName, lastModified);
        parent.appendChild(this);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    public static void main(String[] args) {
        System.out.println("APFSFile run successfully");
    }
}
