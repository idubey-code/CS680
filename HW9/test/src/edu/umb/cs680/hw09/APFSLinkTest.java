package edu.umb.cs680.hw09;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class APFSLinkTest {

    static LocalDateTime localTime = LocalDateTime.of(2020, 05, 12, 0, 0);
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
    public void verifyTargetEqualityfileb() {
        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
        String[] expected = { "false", "b", "700", localTime.toString(), "applications" };
        //tried for a worked in hw9
        APFSFile actual = (APFSFile) root.findByName_Link("y").getTarget();
        assertArrayEquals(expected,stringelementforfs(actual));
    }
    @Test
    public void testforhome() {
        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
        String[] expected = { "true", "applications", "0", localTime.toString(), "root" };
        APFSDirectory actual = (APFSDirectory) root.findByName_Link("x").getTarget();
        assertArrayEquals(expected,stringelementforfs(actual));
    }


    @Test
    public void verifyTargetEqualityB() {
        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
        String[] expected = { "false", "b", "700", localTime.toString(), "applications" };
        // this needs to return true for applications as b is a  part of applications but still returning false.
        APFSFile actual = (APFSFile) root.findByName_Link("y").getTarget();
        assertArrayEquals(expected,stringelementforfs(actual));
    }

}
