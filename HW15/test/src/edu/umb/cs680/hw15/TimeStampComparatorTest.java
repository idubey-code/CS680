package edu.umb.cs680.hw15;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TimeStampComparatorTest {
	
static LocalDateTime localTime = LocalDateTime.of(2020, 05, 22, 0, 0);
private String[] arraystringfordirectory(LinkedList<APFSElement> fsElements) {
	String[] listnamefile = new String[fsElements.size()];
	int i = 0;
	for(APFSElement afpselement : fsElements) {
		listnamefile[i] = afpselement.getName();
		i++;
	}
	return listnamefile;
}
	@SuppressWarnings("unused")
	@BeforeAll
	public static void setupupoffilestructure() {
		
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)ApfsFileSystem.initFileSystem("drive", 3500);
		APFSDirectory applications = new APFSDirectory(root, "applications", 0, localTime, "Ishan", LocalDateTime.of(2020, 05, 12, 0, 0));
		APFSDirectory home = new APFSDirectory(root, "home", 0, localTime, "Ishan", LocalDateTime.of(2020, 05, 21, 10, 0));
		APFSDirectory code = new APFSDirectory(home, "code", 0, localTime, "Ishan", LocalDateTime.of(2020, 05, 21, 5, 0));
		APFSFile a = new APFSFile(applications, "a", 350, localTime, "Ishan", LocalDateTime.of(2020, 05, 22, 10, 0));
		APFSFile b = new APFSFile(applications, "b", 700, localTime, "Ishan", LocalDateTime.of(2020, 05, 23, 10, 0));
		APFSFile c = new APFSFile(home, "c", 800, localTime, "Ishan", LocalDateTime.of(2020, 05, 22, 15, 0));
		APFSFile d = new APFSFile(home, "d", 80, localTime, "Ishan", LocalDateTime.of(2020, 05, 23, 20, 0));
		APFSFile apfselement = new APFSFile(code, "apfselement", 700, localTime, "Ishan", LocalDateTime.of(2020, 05, 22, 23, 0));
		APFSFile f = new APFSFile(code, "f", 870, localTime, "Ishan", LocalDateTime.of(2020, 05, 23, 0, 20));
		APFSLink x = new APFSLink(home, "x", 0, localTime, "Ishan", LocalDateTime.of(2020, 05, 24, 0, 15), applications);
		APFSLink y = new APFSLink(code, "y", 0, localTime, "Ishan", LocalDateTime.of(2020, 05, 24, 0, 20), b);
	}
	
	
	
	
	@Test
	void testforreversecomparatorchildren() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)ApfsFileSystem.getRootDir();
		String[] expected = {"applications", "home"};
		assertArrayEquals(expected,arraystringfordirectory(root.getChildren((APFSElement object1, APFSElement object2) -> object1.getLastModified().compareTo(object2.getLastModified()))));
	}
	
	
	@Test
	void testforreversecomparatorfilesforcode() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)ApfsFileSystem.getRootDir();
		String[] expected = {"apfselement", "f"};
		LinkedList<APFSElement> actual = new LinkedList<APFSElement>();
		for(APFSElement apfselement : root.findByName_Directory("code").getFiles((APFSElement object1, APFSElement object2) -> object1.getLastModified().compareTo(object2.getLastModified()))){
			actual.add(apfselement);
		}
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	@Test
	void testforreversecomparatordirectory() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)ApfsFileSystem.getRootDir();
		String[] expected = {"applications", "home"};
		LinkedList<APFSElement> actual = new LinkedList<APFSElement>();
		for(APFSElement apfselement : root.getSubDirectories((APFSElement object1, APFSElement object2) -> object1.getLastModified().compareTo(object2.getLastModified()))){
			actual.add(apfselement);
		}
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	@Test
	void testforreversecomparatorfilesforhome() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)ApfsFileSystem.getRootDir();
		String[] expected = {"c", "d"};
		LinkedList<APFSElement> actual = new LinkedList<APFSElement>();
		for(APFSElement apfselement : root.findByName_Directory("home").getFiles((APFSElement object1, APFSElement object2) -> object1.getLastModified().compareTo(object2.getLastModified()))){
			actual.add(apfselement);
		}
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
}
