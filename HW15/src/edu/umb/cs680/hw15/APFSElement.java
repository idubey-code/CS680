package edu.umb.cs680.hw15;

import java.time.LocalDateTime;

public abstract class APFSElement extends FSElement{
	public APFSElement(APFSDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName, LocalDateTime lastModified) {
		super(parent, name, size, creationTime);
		this.ownerName = ownerName;
		this.lastModified = lastModified;
	}
	private String ownerName;
	private LocalDateTime lastModified;

	public String getOwnerName() {
		return ownerName;
	}
	public abstract boolean isDirectory();
	public LocalDateTime getLastModified() {
		return lastModified;
	}

	public static void main(String[] args) {
		System.out.println("APFSElement is run successfully");
	}
}
