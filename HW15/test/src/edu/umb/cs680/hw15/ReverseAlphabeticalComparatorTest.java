package edu.umb.cs680.hw15;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReverseAlphabeticalComparatorTest {

	static LocalDateTime localTime = LocalDateTime.of(2020, 05, 22, 0, 0);
	private String[] arraystringfordirectory(LinkedList<APFSElement> fsElements) {
		String[] Listfilename = new String[fsElements.size()];
		int i = 0;
		for(APFSElement Apfselement : fsElements) {
			Listfilename[i] = Apfselement.getName();
			i++;
		}
		return Listfilename;
	}
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
		APFSFile Apfselement = new APFSFile(code, "Apfselement", 700, localTime, "Ishan", localTime);
		APFSFile f = new APFSFile(code, "f", 870, localTime, "Ishan", localTime);
		APFSLink x = new APFSLink(home, "x", 0, localTime, "Ishan", localTime, applications);
		APFSLink y = new APFSLink(code, "y", 0, localTime, "Ishan", localTime, b);
	}
	
	
	@Test
	void testcomparatorreverseforfiles() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)ApfsFileSystem.getRootDir();
		String[] expected = {"b", "a"};
		LinkedList<APFSElement> actual = new LinkedList<APFSElement>();
		for(APFSElement Apfselement : root.findByName_Directory("applications").getFiles((APFSElement object1, APFSElement object2) -> object2.getName().compareTo(object1.getName()))){
			actual.add(Apfselement);
		}
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	@Test
	void testcomparatorreverseforchild() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)ApfsFileSystem.getRootDir();
		String[] expected = {"home", "applications"};
		assertArrayEquals(expected,arraystringfordirectory(root.getChildren((APFSElement object1, APFSElement object2) -> object2.getName().compareTo(object1.getName()))));
	}

	@Test
	void testcomparatorreversefordirectory() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)ApfsFileSystem.getRootDir();
		String[] expected = {"home", "applications"};
		LinkedList<APFSElement> actual = new LinkedList<APFSElement>();
		for(APFSElement Apfselement : root.getSubDirectories((APFSElement object1, APFSElement object2) -> object2.getName().compareTo(object1.getName()))){
			actual.add(Apfselement);
		}
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	
}
