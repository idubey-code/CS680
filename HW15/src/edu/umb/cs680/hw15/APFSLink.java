package edu.umb.cs680.hw15;

import java.time.LocalDateTime;

public class APFSLink extends APFSElement {

	
	
	public APFSElement getTarget() {
		return target;
	}
	@Override
	public boolean isDirectory() {
		return false;
	}
	public APFSLink(APFSDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName, LocalDateTime lastModified, APFSElement target) {
		super(parent, name, size, creationTime, ownerName, lastModified);
		this.target = target;
		parent.appendChild(this);
	}
	private APFSElement target;
	

	public static void main(String[] args) {
		System.out.println("APFSLink class is run successfully");
	}
}
