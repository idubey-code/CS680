package edu.umb.cs680.hw12;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class APFSLink extends APFSElement {

	LinkedList<APFSElement> children = new LinkedList<>();
	APFSElement target;
	
	public APFSLink(APFSElement parent, String name, int size, LocalDateTime creationTime, APFSElement target, String owner, LocalDateTime lastModification) {
		super(parent, name, size, creationTime,owner,lastModification);
		this.target = target;
	}

	@Override
	public Boolean isDirectory() {
		return true;
	}

	public APFSElement getTargetLink() {
		return target;
	}
	
	public void setTargetLink(APFSElement target) {
		this.target = target;
	}
	
	@Override
	public void accept(APFSFSVisitor v) {
		v.visit(this);
	}
	
	public static void main(String[] args) {
		System.out.println("Success from APFSLink");
	}
}