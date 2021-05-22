package edu.umb.cs680.hw10;

import java.util.ArrayList;

public class APFSFileCrawlingVisitor implements APFSFSVisitor {

    private ArrayList<APFSFile> files;
    @Override
    public void visit(APFSDirectory dir) {
        return;
    }
    public ArrayList<APFSFile> getFiles() {
        if(null == files) {
            files = new ArrayList<APFSFile>();
        }
        return files;
    }



    @Override
    public void visit(APFSFile file) {
        if(null == files) {
            files = new ArrayList<APFSFile>();
        }
        files.add(file);
    }
    @Override
    public void visit(APFSLink link) {
        return;
    }

    public static void main(String[] args) {
        System.out.println("Success from APFSFileCrawlingVisitor.");
    }
}