package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw09.APFS;
import edu.umb.cs680.hw09.APFSDirectory;
import edu.umb.cs680.hw09.APFSFile;

class APFSFileTest {

    static LocalDateTime localTime = LocalDateTime.of(2020, 05, 12, 0, 0);
    private String[] arraystringforfile(APFSFile Elementforfs) {
        Optional<APFSDirectory> optionalDirectory = Optional.ofNullable(Elementforfs.getParent());
        String[] informationoffile = { Boolean.toString(Elementforfs.isDirectory()), Elementforfs.getName(),
                Integer.toString(Elementforfs.getSize()), Elementforfs.getCreationTime().toString(),
                optionalDirectory.isPresent()?Elementforfs.getParent().getName():null, Elementforfs.getOwnerName(),Elementforfs.getLastModified().toString()};
        return informationoffile;
    }
    @SuppressWarnings("unused")
    @BeforeAll
    public static void initialize() {

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
    public void verifyFileEqualityfile() {
        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
        String[] expected = { "false", "e", "700", localTime.toString(), "code", "Ishan", localTime.toString() };
        APFSFile actual = root.findByName_File("e");
        assertArrayEquals(expected,arraystringforfile(actual));
    }
    @Test
    void testfordir() {
        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
        assertTrue(root.findByName_Directory("root").isDirectory());
        assertTrue(root.findByName_Directory("home").isDirectory());
        assertTrue(root.findByName_Directory("applications").isDirectory());
        assertTrue(root.findByName_Directory("code").isDirectory());
        assertFalse(root.findByName_File("a").isDirectory());
        assertFalse(root.findByName_File("b").isDirectory());
        assertFalse(root.findByName_File("c").isDirectory());
        assertFalse(root.findByName_File("d").isDirectory());
        assertFalse(root.findByName_File("e").isDirectory());
        assertFalse(root.findByName_File("f").isDirectory());
    }

    @Test
    public void verifyFileEqualityforA() {
        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
        String[] expected = { "false", "a", "350", localTime.toString(), "applications", "Ishan", localTime.toString() };
        APFSFile actual = root.findByName_File("a");
        assertArrayEquals(expected,arraystringforfile(actual));
    }

    @Test
    public void verifyFileEqualityforB() {
        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
        String[] expected = { "false", "b", "700", localTime.toString(), "applications", "Ishan", localTime.toString() };
        APFSFile actual = root.findByName_File("b");
        assertArrayEquals(expected,arraystringforfile(actual));
    }

    @Test
    public void verifyFileEqualityforC() {
        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
        String[] expected = { "false", "c", "800", localTime.toString(), "home", "Ishan", localTime.toString() };
        APFSFile actual = root.findByName_File("c");
        assertArrayEquals(expected,arraystringforfile(actual));
    }
    @Test
    public void verifyFileEqualityforD() {
        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
        String[] expected = { "false", "d", "80", localTime.toString(), "home", "Ishan", localTime.toString() };
        APFSFile actual = root.findByName_File("d");
        assertArrayEquals(expected,arraystringforfile(actual));
    }


    @Test
    public void verifyFileEqualityforE() {
        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
        String[] expected = { "false", "e", "700", localTime.toString(), "code", "Ishan", localTime.toString() };
        APFSFile actual = root.findByName_File("e");
        assertArrayEquals(expected,arraystringforfile(actual));
    }
    @Test
    public void verifyFileEqualityforF() {
        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
        String[] expected = { "false", "f", "870", localTime.toString(), "code", "Ishan", localTime.toString() };
        APFSFile actual = root.findByName_File("f");
        assertArrayEquals(expected,arraystringforfile(actual));
    }

}