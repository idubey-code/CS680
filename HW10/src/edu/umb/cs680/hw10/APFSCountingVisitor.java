package edu.umb.cs680.hw10;

public class APFSCountingVisitor implements APFSFSVisitor {

    private int d_Num = 0;
    private int f_Num = 0;
    private int l_Num = 0;
    @Override
    public void visit(APFSDirectory dir) {
        d_Num++;
    }
    public int getDirNum() {
        return d_Num;
    }

    public int getFileNum() {
        return f_Num;
    }



    @Override
    public void visit(APFSLink link) {
        l_Num++;
    }


    public int getLinkNum() {
        return l_Num;
    }

    @Override
    public void visit(APFSFile file) {
        f_Num++;
    }

    public static void main(String[] args) {
        System.out.println("Success from APFSCountingVisitor");
    }
}