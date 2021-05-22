package edu.umb.cs680.hw10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class APFSFileSearchVisitorTest {

    static LocalDateTime localTime = LocalDateTime.of(2020, 05, 20, 0, 0);
    private String[] arraystringfordirectory(APFSFile f) {
        Optional<APFSDirectory> optionalDirectory = Optional.ofNullable(f.getParent());
        String[] fileInfo = { Boolean.toString(f.isDirectory()), f.getName(),
                Integer.toString(f.getSize()), f.getCreationTime().toString(),
                optionalDirectory.isPresent()?f.getParent().getName():null, f.getOwnerName(),f.getLastModified().toString()};
        return fileInfo;
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
    public void verifyFileEqualityA() {
        APFSFileSearchVisitor apfsvisior = new APFSFileSearchVisitor();
        APFS APFSFileSystem = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)APFSFileSystem.getRootDir();
        String[] expected = { "false", "a", "350", localTime.toString(), "applications", "Ishan", localTime.toString() };
        apfsvisior.setFileName("a");
        root.accept(apfsvisior);
        APFSFile actual = apfsvisior.getFile();
        assertArrayEquals(expected,arraystringfordirectory(actual));
    }

    @Test
    public void verifyFileEqualityB() {
        APFSFileSearchVisitor apfsvisior = new APFSFileSearchVisitor();
        APFS APFSFileSystem = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)APFSFileSystem.getRootDir();
        String[] expected = { "false", "b", "700", localTime.toString(), "applications", "Ishan", localTime.toString() };
        apfsvisior.setFileName("b");
        root.accept(apfsvisior);
        APFSFile actual = apfsvisior.getFile();
        assertArrayEquals(expected,arraystringfordirectory(actual));
    }

    @Test
    public void verifyFileEqualityC() {
        APFSFileSearchVisitor apfsvisior = new APFSFileSearchVisitor();
        APFS APFSFileSystem = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)APFSFileSystem.getRootDir();
        String[] expected = { "false", "c", "800", localTime.toString(), "home", "Ishan", localTime.toString() };
        apfsvisior.setFileName("c");
        root.accept(apfsvisior);
        APFSFile actual = apfsvisior.getFile();
        assertArrayEquals(expected,arraystringfordirectory(actual));
    }





}