package edu.umb.cs680.hw15;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FileSystemTest {

static LocalDateTime localTime = LocalDateTime.of(2020, 05, 22, 0, 0);
private String[] arraystringfordirectory(APFSDirectory directory) {
	APFS FilesystemofApfs = APFS.getAPFSFileSystem();
	Optional<APFSDirectory> optionalDirectory = Optional.ofNullable(directory.getParent());
	String[] inforofdirectory = { Boolean.toString(directory.isDirectory()), directory.getName(), 
			Integer.toString(directory.getSize()), directory.getCreationTime().toString(), 
			optionalDirectory.isPresent()?directory.getParent().getName():null, 
					Integer.toString(directory.getTotalSize()),
					Integer.toString(directory.countChildren()), FilesystemofApfs.getFileSystemName(), 
					Integer.toString(FilesystemofApfs.getCapacity()), directory.getOwnerName(),directory.getLastModified().toString() };
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
		APFSFile e = new APFSFile(code, "e", 700, localTime, "Ishan", localTime);
		APFSFile f = new APFSFile(code, "f", 870, localTime, "Ishan", localTime);
		APFSLink x = new APFSLink(home, "x", 0, localTime, "Ishan", localTime, applications);
		APFSLink y = new APFSLink(code, "y", 0, localTime, "Ishan", localTime, b);
	}
	@Test
	public void Testforfileowner() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
		assertEquals(root.getOwnerName(), "Ishan");
		assertEquals(root.getLastModified(), localTime);
	}
	
	
	@Test
	public void testfordirectorysetup() {
		APFS FilesystemofApfs = APFS.getAPFSFileSystem();
		APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
		String[] expected = { "true", "root", "0", localTime.toString(), null, "3500", "2", "drive", "3500", "Ishan", localTime.toString()};
		APFSDirectory actual = root.findByName_Directory("root");
		assertArrayEquals(expected,arraystringfordirectory(actual));
	}
	
	

}
