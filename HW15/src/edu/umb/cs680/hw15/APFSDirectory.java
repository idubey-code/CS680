package edu.umb.cs680.hw15;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


public class APFSDirectory extends APFSElement {
	
	private LinkedList<APFSElement> child;
	public void appendChild(APFSElement child) {
		if(this.child == null) {
			this.child = new LinkedList<APFSElement>();
		}
		this.child.add(child);
	}
	public LinkedList<APFSElement> getChildren() {
		if(this.child == null) {
			this.child = new LinkedList<APFSElement>();
		}
		Collections.sort(child, (APFSElement object1, APFSElement object2) -> object1.getName().compareTo(object1.getName()));
		return child;
	}

	public APFSDirectory(APFSDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName, LocalDateTime lastModified) {
		super(parent, name, size, creationTime, ownerName, lastModified);
		if(parent != null)
			parent.appendChild(this);
	}

	@Override
	public boolean isDirectory() {
		return true;
	}
	
	
	public LinkedList<APFSFile> getFiles(Comparator<APFSElement> comparator) {
		LinkedList<APFSFile> fileList = getFiles();
		Collections.sort(fileList, comparator);
		return fileList;
	}
	public int countChildren() {
		return getChildren().size() - getLinks().size();
	}
	
	public LinkedList<APFSDirectory> getSubDirectories() {
		LinkedList<APFSDirectory> listofdir = new LinkedList<APFSDirectory>();
		for(FSElement a : getChildren()) {
			if(a instanceof APFSDirectory)
				listofdir.add((APFSDirectory) a);
		}
		Collections.sort(listofdir, (APFSElement object1, APFSElement object2) -> object1.getName().compareTo(object2.getName()));
		return listofdir;	
	}

	
	
	public LinkedList<APFSLink> getLinks() {
		LinkedList<APFSLink> linkList = new LinkedList<APFSLink>();
		for(FSElement a : getChildren()) {
			if(a instanceof APFSLink)
				linkList.add((APFSLink) a);
		}
		return linkList;
	}
	
	public int getTotalSize() {
		int totalSize = 0;
		for(APFSElement a : getChildren()) {
			if(a instanceof APFSDirectory)
				totalSize += ((APFSDirectory) a).getTotalSize();
			else
				totalSize += a.getSize();
		}
		return totalSize;
	}
	public LinkedList<APFSFile> getFiles() {
		LinkedList<APFSFile> fileList = new LinkedList<APFSFile>();
		for(FSElement a : getChildren()) {
			if(a instanceof APFSFile)
				fileList.add((APFSFile) a);
		}
		Collections.sort(fileList, (APFSElement object1, APFSElement object2) -> object1.getName().compareTo(object2.getName()));
		return fileList;
	}
	public APFSDirectory findByName_Directory(String dirName) {
		APFSDirectory directory = null;
		if(dirName.equals(getName()))
			directory = this;
		else {
			for(APFSDirectory dir : getSubDirectories()) {
				if(directory == null) {
					directory = dir.findByName_Directory(dirName);
					if(dirName.equals(dir.getName())) {
						directory = dir;
						break;
					}
				}
			}
		}
		return directory;
	}
	
	
	
	public APFSLink findByName_Link(String linkName) {
		APFSLink link = null;
		for(APFSLink l : getLinks()) {
			if(linkName.equals(l.getName()))
				link = l;
		}
		if(link == null) {
			for(APFSDirectory dir : getSubDirectories()) {
				link = dir.findByName_Link(linkName);
				if(link != null)
					break;
			}
		}
		return link;
	}
	
	public LinkedList<APFSElement> getChildren(Comparator<APFSElement> comparator) {
		Collections.sort(getChildren(), comparator);
		return child;
	}
	
	public LinkedList<APFSDirectory> getSubDirectories(Comparator<APFSElement> comparator) {
		LinkedList<APFSDirectory> listofdir = getSubDirectories();
		Collections.sort(listofdir, comparator);
		return listofdir;
	}
	public APFSFile findFileByName(String fileName) {
		APFSFile file = null;
		for(APFSFile f : getFiles()) {
			if(fileName.equals(f.getName()))
				file = f;
		}
		if(file == null) {
			for(APFSDirectory dir : getSubDirectories()) {
				file = dir.findFileByName(fileName);
				if(file != null)
					break;
			}
		}
		return file;
	}
	
	
	public static void main(String[] args) {
		System.out.println("APFSDirectory is run successfully");
	}
}
