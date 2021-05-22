package edu.umb.cs680.hw10;

public class APFSFileSearchVisitor implements APFSFSVisitor {

    private String f_Name;
    private APFSFile file;


    @Override
    public void visit(APFSDirectory dir) {
        return;
    }
    public void setFileName(String f_Name) {
        this.f_Name = f_Name;
    }

    @Override
    public void visit(APFSLink link) {
        return;
    }
    public APFSFile getFile() {
        return file;
    }


    @Override
    public void visit(APFSFile file) {
        if(f_Name.equals(file.getName()))
            this.file = file;
    }

    public static void main(String[] args) {
        System.out.println("Success from APFSFileSearchVisitor.");
    }
}