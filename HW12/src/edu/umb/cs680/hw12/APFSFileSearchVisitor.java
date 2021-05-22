package edu.umb.cs680.hw12;

public class APFSFileSearchVisitor<T> implements APFSFSVisitor<T> {

	APFSFile file;
	@Override
	public void visit(APFSLink link) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(APFSDirectory dir) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(APFSFile file) {
		// TODO Auto-generated method stub
		this.file = file;
	}
	
	public boolean search(String fileName) {
		if(fileName.equals(file.getName()))
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println("Success from APFSFileSearchVisitor");
	}
}
