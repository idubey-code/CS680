package edu.umb.cs680.hw12;

import java.util.Comparator;

public class ElementComparator implements Comparator<APFSElement>{

	@Override
	public int compare(APFSElement f1, APFSElement f2) {
		// TODO Auto-generated method stub
		if(f1 instanceof APFSDirectory && f2 instanceof APFSDirectory)
			return 3;
		else if(f1 instanceof APFSDirectory && f2 instanceof APFSFile)
			return 2;
		else if(f2 instanceof APFSDirectory && f1 instanceof APFSFile)
			return 1;
		else 
			return 0;
	}

	public static void main(String[] args) {
		System.out.println("Success from ElementComparator");
	}
}
