package edu.umb.cs680.hw12;

public interface APFSFSVisitor<T> {
	public void visit(APFSLink link) ;
	public void visit(APFSDirectory dir);
	public void visit(APFSFile file) ;
	
	public static void main(String[] args) {
		System.out.println("Success from APFSFSVisitor");
	}
}
