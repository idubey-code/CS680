package edu.umb.cs680.hw12;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class TimeStampComparatorTest {
	
	APFS fs;

	private void before() {
		fs = APFS.getFileSystem();
		APFSDirectory root = new APFSDirectory(null, "Root", 0, LocalDateTime.of(2020, 05, 21, 3,0), "Ishan", null);



		APFSDirectory system = new APFSDirectory(root, "System", 0, LocalDateTime.of(2020, 05, 21, 3,0), "Ishan", null);
		root.appendChild(system);

		APFSDirectory home = new APFSDirectory(root, "Home", 0, LocalDateTime.of(2019, 2, 2, 13, 0), "Ishan", null);
		root.appendChild(home);

		APFSDirectory picture = new APFSDirectory(home, "Picture", 0, LocalDateTime.of(2019, 3, 2, 12, 0), "Ishan", null);
		home.appendChild(picture);

		APFSFile a = new APFSFile(system, "a.txt", 100, LocalDateTime.of(2020, 05, 21, 3,0), "Ishan", null);

		APFSFile b = new APFSFile(system, "b.txt", 200, LocalDateTime.of(2020, 05, 21, 3,0), "Ishan", null);

		APFSFile c = new APFSFile(system, "c.txt", 100, LocalDateTime.of(2020, 05, 21, 3,0), "Ishan", null);
		system.appendChild(a);
		system.appendChild(b);
		system.appendChild(c);
		
		APFSFile d = new APFSFile(home, "d.txt", 400, LocalDateTime.of(2020, 05, 21, 3,0), "Ishan", null);
		home.appendChild(d);
		
		APFSFile e = new APFSFile(picture, "e.txt", 500, LocalDateTime.of(2020, 05, 21, 3,0), "Ishan", null);

		APFSFile f = new APFSFile(picture, "f.txt", 100, LocalDateTime.of(2020, 05, 21, 3,0), "Ishan", null);
		
		APFSLink x = new APFSLink(home, "x", 0, LocalDateTime.of(2020, 05, 21, 3,0), system, "Ishan", null);
		home.appendChild(x);

		APFSLink y = new APFSLink(picture, "y", 0, LocalDateTime.of(2020, 05, 21, 3,0), e, "Ishan", null);
		
		picture.appendChild(y);
		picture.appendChild(e);
		picture.appendChild(f);
		fs.setRoot(root);

	}
	

	@Test
	public void verifyLinkEqualitySystem() {
		before();
		LinkedList<APFSElement> l1 = ((APFSDirectory)fs.getRoot()).getChildren();
		String str = l1.getFirst().getName();
		LinkedList<APFSElement> l2 = ((APFSDirectory)fs.getRoot()).getChildren(new TimeStampComparator());
		String str1 = l2.getLast().getName();
		assertEquals(str, str1);
	}
}
