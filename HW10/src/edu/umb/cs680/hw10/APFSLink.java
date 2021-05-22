package edu.umb.cs680.hw10;

import java.time.LocalDateTime;

public class APFSLink extends APFSElement {

    private APFSElement target;

    public APFSElement getTarget() {
        return target;
    }

    public APFSLink(APFSDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName, LocalDateTime lastModified, APFSElement target) {
        super(parent, name, size, creationTime, ownerName, lastModified);
        this.target = target;
        parent.appendChild(this);
    }
    @Override
    public void accept(APFSFSVisitor visitor) {
        visitor.visit(this);
    }
    @Override
    public boolean isDirectory() {
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Success from APFSLink.");
    }
}