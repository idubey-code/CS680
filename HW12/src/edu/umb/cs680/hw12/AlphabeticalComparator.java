package edu.umb.cs680.hw12;

import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<APFSElement>{

	@Override
	public int compare(APFSElement f1, APFSElement f2) {
		// TODO Auto-generated method stub
		return f1.getName().toString().compareTo(f2.getName().toString());
	}

	public static void main(String[] args) {
		System.out.println("Success from AlphabeticalComparator");
	}
	
}
