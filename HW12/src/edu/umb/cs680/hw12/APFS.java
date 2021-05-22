package edu.umb.cs680.hw12;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class APFS extends FileSystem {
	
	private static APFS fs = null;
	
	private APFS() {
	}

	public static APFS getFileSystem() {
		if (fs == null) {
			fs = new APFS();
			fs.initFileSystem("Root", 1800);
		}
		return fs;
	}

	public LinkedList<APFSElement> getRootDirs(APFSElement d) {
		LinkedList<APFSElement> child = new LinkedList<>();
		while (d.getParent() != null) {
			child.add(d.getParent());
			d = d.getParent();
		}
		return child;
	}

	@Override
	protected FSElement createDefaultRoot() {
		return new APFSDirectory(null, "Root", 0, LocalDateTime.of(2019, 2, 2, 12, 0), "Ishan", null);
	}
	
	public void setRootDir(APFSDirectory root) {
		super.setRoot(root);
	}
	
	public APFSDirectory getRootDir() {
		return (APFSDirectory)this.getRoot();
	}
	
	public static void main(String[] args) {
		System.out.println("Success from APFS");
	}
}