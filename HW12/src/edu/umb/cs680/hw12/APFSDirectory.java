package edu.umb.cs680.hw12;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class APFSDirectory extends APFSElement {

	LinkedList<APFSElement> children = new LinkedList<>();
	
	public APFSDirectory(APFSElement parent, String name, int size, LocalDateTime creationTime, String owner, LocalDateTime lastModification) {
		super(parent, name, size, creationTime,owner,lastModification);
	}

	@Override
	public Boolean isDirectory() {
		return true;
	}

	public LinkedList<APFSElement> getChildren(){
		return children;
	}
	
	public void appendChild(APFSElement child) {
		children.add(child);
	}

	public int countChildren() {
		LinkedList<FSElement> child = new LinkedList<>();
		int count = 0;
		child.addAll(children);
		for(FSElement e: child) {
			if(e.isDirectory())
				child.add(e);
			else
				count += 1;
			child.remove(e);
		}
		return count;
	}
	
	public int getTotalSize() {
		LinkedList<FSElement> child = new LinkedList<>();
		int count = 0;
		child.addAll(children);
		while(child.size() != 0) {
			FSElement e = child.get(0);
			if(e instanceof APFSLink && ((APFSLink) e).getTargetLink() instanceof APFSDirectory) {
				child.add(((APFSLink) e).getTargetLink());
			}
			else if(e instanceof APFSDirectory && e.isDirectory())
				child.addAll(((APFSDirectory) e).getChildren());
			else
				count += e.getSize();
			child.remove(0);
		}
		return count;
	}
	
	public LinkedList<APFSElement> getSubDirectories(){
		LinkedList<APFSElement> child = new LinkedList<>();
		for(APFSElement e: children) {
				child.add(e);
		}
		return child;
	}
	
	public LinkedList<APFSFile> getFiles(){
		LinkedList<APFSFile> child = new LinkedList<>();
		for(FSElement e: children) {
			if(!e.isDirectory())
				child.add((APFSFile) e);
		}
		return child;
	}
	
	@Override
	public void accept(APFSFSVisitor v) {
		v.visit(this);
		for(APFSElement e: children){
            e.accept(v); 
        }
	}
	
	public LinkedList<APFSElement> getChildren(Comparator<APFSElement> compare) {
		Collections.sort(children, compare);
		return children;
	}
	
	public LinkedList<APFSElement> getSubDirectories(Comparator<APFSElement> compare){
		return children;
	}
	
	public LinkedList<APFSElement> getFiles(Comparator<APFSElement> compare){
		return children;
	}
	public static void main(String[] args) {
		System.out.println("Success from APFSDirectory.");
	}
	
}