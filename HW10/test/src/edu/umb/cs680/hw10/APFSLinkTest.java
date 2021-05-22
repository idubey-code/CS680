package edu.umb.cs680.hw10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class APFSLinkTest {

    static LocalDateTime localTime = LocalDateTime.of(2020, 05, 20, 0, 0);
    private String[] stringelementforfs(FSElement Elementforfs) {
        Optional<APFSDirectory> optionalDirectory = Optional.ofNullable(Elementforfs.getParent());
        String[] informationoffs = { Boolean.toString(Elementforfs.isDirectory()), Elementforfs.getName(),
                Integer.toString(Elementforfs.getSize()), Elementforfs.getCreationTime().toString(),
                optionalDirectory.isPresent()?Elementforfs.getParent().getName():null};
        return informationoffs;
    }
    @SuppressWarnings("unused")
    @BeforeAll
    public static void setupupoffilestructure() {

        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)FilesystemofApfs.initFileSystem("drive", 3500);
        APFSDirectory applications = new APFSDirectory(root, "applications", 0, localTime, "kedar", localTime);
        APFSDirectory home = new APFSDirectory(root, "home", 0, localTime, "kedar", localTime);
        APFSDirectory code = new APFSDirectory(home, "code", 0, localTime, "kedar", localTime);
        APFSFile a = new APFSFile(applications, "a", 350, localTime, "kedar", localTime);
        APFSFile b = new APFSFile(applications, "b", 700, localTime, "kedar", localTime);
        APFSFile c = new APFSFile(home, "c", 800, localTime, "kedar", localTime);
        APFSFile d = new APFSFile(home, "d", 80, localTime, "kedar", localTime);
        APFSLink x = new APFSLink(home, "x", 0, localTime, "kedar", localTime, applications);
        APFSFile e = new APFSFile(code, "e", 700, localTime, "kedar", localTime);
        APFSFile f = new APFSFile(code, "f", 870, localTime, "kedar", localTime);
        APFSLink y = new APFSLink(code, "y", 0, localTime, "kedar", localTime, b);
    }

    @Test
    public void testforhome() {
        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
        String[] expected = { "true", "home", "0", localTime.toString(), "root" };
        APFSDirectory actual = root.findByName_Directory("home");
        assertArrayEquals(expected,stringelementforfs(actual));
    }

    @Test
    public void verifyTargetEqualitya() {
        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
        String[] expected = { "false", "a", "350", localTime.toString(), "applications" };
        // this needs to return true for applications as b is a  part of applications but still returning false.
        APFSFile actual = root.findByName_File("a");
        assertArrayEquals(expected,stringelementforfs(actual));
    }
    @Test
    public void verifyTargetEqualityB() {
        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
        String[] expected = { "false", "b", "700", localTime.toString(), "applications" };
        // this needs to return true for applications as b is a  part of applications but still returning false.
        APFSFile actual = root.findByName_File("b");
        assertArrayEquals(expected,stringelementforfs(actual));
    }

}
