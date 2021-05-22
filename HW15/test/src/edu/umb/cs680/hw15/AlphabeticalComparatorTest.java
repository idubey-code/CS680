package edu.umb.cs680.hw15;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class AlphabeticalComparatorTest {

	static LocalDateTime localTime = LocalDateTime.of(2020, 05, 22, 0, 0);
	private String[] Stringarrayforelement(LinkedList<APFSElement> fsElements) {
		String[] listoffilename = new String[fsElements.size()];
		int i = 0;
		for(APFSElement elementforapfs : fsElements) {
			listoffilename[i] = elementforapfs.getName();
			i++;
		}
		return listoffilename;
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
		APFSFile e = new APFSFile(code, "e", 700, localTime, "Ishan", localTime);
		APFSFile f = new APFSFile(code, "f", 870, localTime, "Ishan", localTime);
		APFSLink x = new APFSLink(home, "x", 0, localTime, "Ishan", localTime, applications);
		APFSLink y = new APFSLink(code, "y", 0, localTime, "Ishan", localTime, b);
	}
	@Test
	void testorderofchild() {
		APFS Apfssystemfile = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)Apfssystemfile.getRootDir();
		String[] expected = {"applications", "home"};
		assertArrayEquals(expected,Stringarrayforelement(root.getChildren()));
	}
	@Test
	void checkOrderOfFiles() {
		APFS Apfssystemfile = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)Apfssystemfile.getRootDir();
		String[] expected = {"a", "b"};
		LinkedList<APFSElement> actual = new LinkedList<APFSElement>();
		for(APFSElement apfselement : root.findByName_Directory("applications").getFiles()){
			actual.add(apfselement);
		}
		assertArrayEquals(expected,Stringarrayforelement(actual));
	}
	
	
	@Test
	void testdireorder() {
		APFS Apfssystemfile = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)Apfssystemfile.getRootDir();
		String[] expected = {"applications", "home"};
		LinkedList<APFSElement> actual = new LinkedList<APFSElement>();
		for(APFSElement apfselement : root.getSubDirectories()){
			actual.add(apfselement);
		}
		assertArrayEquals(expected,Stringarrayforelement(actual));
	}
	
	
}
