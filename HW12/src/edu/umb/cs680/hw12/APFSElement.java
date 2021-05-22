package edu.umb.cs680.hw12;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class APFSElement extends FSElement {

	
	private APFSFSVisitor v;

	public void accept(APFSFSVisitor v) {
		this.v = v;
	}
	
	private String ownerName;
	private LocalDateTime lastModification;
	
	public LocalDateTime getLastModification() {
		return lastModification;
	}

	public void setLastModification(LocalDateTime lastModification) {
		this.lastModification = lastModification;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	LinkedList<APFSElement> children = new LinkedList<>();
	
	public APFSElement(APFSElement parent, String name, int size, LocalDateTime creationTime, String owner, LocalDateTime lastModification) {
		super(parent, name, size, creationTime);
		this.lastModification = lastModification;
		this.ownerName = owner;
	}

	@Override
	public Boolean isDirectory() {
		return true;
	}

	LinkedList<APFSElement> getChildren(){
		return children;
	}
	
	public void appendChild(APFSElement child) {
		children.add(child);
	}

	public int countChildren() {
		LinkedList<APFSElement> child = new LinkedList<>();
		int count = 0;
		child.addAll(children);
		for(APFSElement e: child) {
			if(e.isDirectory())
				child.add(e);
			else
				count += 1;
			child.remove(e);
		}
		return count;
	}
	
	public int getTotalSize() {
		LinkedList<APFSElement> child = new LinkedList<>();
		int count = 0;
		child.addAll(children);
		while(child.size() != 0) {
			APFSElement e = child.get(0);
			if(e instanceof APFSLink && ((APFSLink)e).getTargetLink() instanceof APFSDirectory) {
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
		for(APFSElement e: children) {
			if(!e.isDirectory())
				child.add((APFSFile) e);
		}
		return child;
	}
	
	public static void main(String[] args) {
		System.out.println("Success from APFSElement.");
	}
}