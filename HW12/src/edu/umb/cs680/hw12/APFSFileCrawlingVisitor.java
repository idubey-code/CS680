package edu.umb.cs680.hw12;

import java.util.ArrayList;

public class APFSFileCrawlingVisitor<T> implements APFSFSVisitor<T> {

	ArrayList<APFSFile> files = new ArrayList<>();
	
	@Override
	public void visit(APFSLink link) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void visit(APFSDirectory dir) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void visit(APFSFile file) {
		// TODO Auto-generated method stub
		files.add(file);
	}
	
	public ArrayList getFiles() {
		return files;
	}

	public static void main(String[] args) {
		System.out.println("Success from APFSFileCrawlingVisitor");
	}
}
