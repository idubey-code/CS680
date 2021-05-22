package edu.umb.cs680.hw15;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ElementBasedComparatorTest {
	
	static LocalDateTime localTime = LocalDateTime.of(2020, 05, 22, 0, 0);
	
	@SuppressWarnings("unused")
	@BeforeAll
public static void setupupoffilestructure() {
		
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)FilesystemofApfs.initFileSystem("drive", 3500);
		APFSDirectory applications = new APFSDirectory(root, "applications", 0, localTime, "Ishan", localTime);
		APFSDirectory home = new APFSDirectory(root, "home", 0, localTime, "Ishan", localTime);
		APFSDirectory code = new APFSDirectory(home, "code", 0, localTime, "Ishan", localTime);
		APFSFile a = new APFSFile(applications, "a", 350, localTime, "Ishan", localTime);
		APFSFile b = new APFSFile(applications, "b", 700, localTime, "Ishan", localTime);
		APFSFile c = new APFSFile(home, "c", 800, localTime, "Ishan", localTime);
		APFSFile d = new APFSFile(home, "d", 80, localTime, "Ishan", localTime);
		APFSFile e = new APFSFile(code, "e", 700, localTime, "Ishan", localTime);
		APFSFile f = new APFSFile(code, "f", 870, localTime, "Ishan", localTime);
		APFSLink x = new APFSLink(home, "x", 0, localTime, "Ishan", localTime, applications);
		APFSLink y = new APFSLink(code, "y", 0, localTime, "Ishan", localTime, b);
	}
	
	private String[] elementToStringArray(LinkedList<APFSElement> fsElements) {
		String[] nameoflistfile = new String[fsElements.size()];
		int i = 0;
		for(APFSElement apfselement : fsElements) {
			nameoflistfile[i] = apfselement.getName();
			i++;
		}
		return nameoflistfile;
	}

	@Test
	void checkElementComparatorSystem() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
		String[] expected = {"code", "c", "d","x"};
		assertArrayEquals(expected,elementToStringArray(root.findByName_Directory("home").getChildren((APFSElement object1, APFSElement object2) -> object1.getOwnerName().compareTo(object2.getOwnerName()))));
	}
	
	@Test
	void checkElementComparatorPictures() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
		String[] expected = {"e", "f", "y"};
		assertArrayEquals(expected,elementToStringArray(root.findByName_Directory("code").getChildren((APFSElement object1, APFSElement object2) -> object1.getOwnerName().compareTo(object2.getOwnerName()))));
	}
}
