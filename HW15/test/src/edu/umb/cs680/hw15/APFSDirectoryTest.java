package edu.umb.cs680.hw15;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class APFSDirectoryTest {

static LocalDateTime localTime = LocalDateTime.of(2020, 05, 22, 0, 0);
private String[] arraystringfordirectory(APFSDirectory directory) {
	Optional<APFSDirectory> optionalDirectory = Optional.ofNullable(directory.getParent());
	String[] inforofdirectory = { Boolean.toString(directory.isDirectory()), directory.getName(), 
			Integer.toString(directory.getSize()), directory.getCreationTime().toString(), 
			optionalDirectory.isPresent()?directory.getParent().getName():null, 
					Integer.toString(directory.getTotalSize()),
					Integer.toString(directory.countChildren()), directory.getOwnerName(),directory.getLastModified().toString()};
	return inforofdirectory;
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
		APFSLink x = new APFSLink(home, "x", 0, localTime, "Ishan", localTime, applications);
		APFSFile e = new APFSFile(code, "e", 700, localTime, "Ishan", localTime);
		APFSFile f = new APFSFile(code, "f", 870, localTime, "Ishan", localTime);
		APFSLink y = new APFSLink(code, "y", 0, localTime, "Ishan", localTime, b);
	}
	
	@Test
	void testforsizedir() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
		assertEquals(3500, root.findByName_Directory("root").getTotalSize());
		assertEquals(2450, root.findByName_Directory("home").getTotalSize());
		assertEquals(1050, root.findByName_Directory("applications").getTotalSize());
		assertEquals(1570, root.findByName_Directory("code").getTotalSize());
	}


	@Test
	void testforfileanddirectory() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
		assertSame("home", root.findByName_Directory("home").getName());
		assertSame("root", root.findByName_Directory("root").getName());
		assertSame("applications", root.findByName_Directory("applications").getName());
		assertSame("code", root.findByName_Directory("code").getName());
		assertSame("a", root.findFileByName("a").getName());	
		assertSame("c", root.findFileByName("c").getName());
		assertSame("d", root.findFileByName("d").getName());
		assertSame("e", root.findFileByName("e").getName());
		assertSame("f", root.findFileByName("f").getName());
		assertSame("b", root.findFileByName("b").getName());
	}
	@Test
	public void verifyDirectoryEqualityHome() { 
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "home", "0", localTime.toString(), "root", "2450", "3", "Ishan", localTime.toString() };
		APFSDirectory actual = root.findByName_Directory("home");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	@Test
	void checkfetchedDirAndFile() {
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)ApfsFileSystem.getRootDir();
		assertSame("home", root.findByName_Directory("home").getName());
		assertSame("root", root.findByName_Directory("root").getName());
		assertSame("applications", root.findByName_Directory("applications").getName());
		assertSame("code", root.findByName_Directory("code").getName());
		assertSame("a", root.findFileByName("a").getName());
		assertSame("f", root.findFileByName("f").getName());
	}
	
	
	@Test
	public void verifyDirectoryEqualityCode() { 
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "code", "0", localTime.toString(), "home", "1570", "2", "Ishan", localTime.toString() };
		APFSDirectory actual = root.findByName_Directory("code");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	@Test
	public void verifyDirectoryEqualityApplications() { 
		APFS ApfsFileSystem = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)ApfsFileSystem.getRootDir();
		String[] expected = { "true", "applications", "0", localTime.toString(), "root", "1050", "2", "Ishan", localTime.toString() };
		APFSDirectory actual = root.findByName_Directory("applications");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	@Test
	void testforinfoonfiles() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
		assertSame("d", root.findByName_Directory("home").getFiles().get(1).getName());
		assertSame("a", root.findByName_Directory("applications").getFiles().get(0).getName());
		assertSame("b", root.findByName_Directory("applications").getFiles().get(1).getName());
		assertSame("c", root.findByName_Directory("home").getFiles().get(0).getName());
	}
	
	@Test
	void testsubdir() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
		assertSame("applications", root.findByName_Directory("root").getSubDirectories().get(0).getName());
		assertSame("home", root.findByName_Directory("root").getSubDirectories().get(1).getName());
	}
	
	@Test
	void testsubfilesindir() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
		assertEquals(2, root.findByName_Directory("root").countChildren());
		assertEquals(2, root.findByName_Directory("applications").countChildren());
		assertEquals(3, root.findByName_Directory("home").countChildren());
		assertEquals(2, root.findByName_Directory("code").countChildren());
	}
	
	@Test
	public void verifyDirectoryEqualityRoot() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "root", "0", localTime.toString(), null, "3500", "2", "Ishan", localTime.toString() };
		APFSDirectory actual = root.findByName_Directory("root");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	
	
	
	

}
