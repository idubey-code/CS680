package edu.umb.cs680.hw10;

public interface APFSFSVisitor {
    public void visit(APFSFile file);
    public void visit(APFSLink link);
    public void visit(APFSDirectory dir);

    public static void main(String[] args) {
        System.out.println("Success from APFSFSVisitor");
    }

}