package edu.umb.cs680.hw12;

import java.util.Comparator;

public class TimeStampComparator implements Comparator<APFSElement>{

	@Override
	public int compare(APFSElement f1, APFSElement f2) {
		// TODO Auto-generated method stub
		return f1.getCreationTime().compareTo(f2.getCreationTime());
	}

	public static void main(String[] args) {
		System.out.println("Success from TimeStampComparator.");
	}

}
