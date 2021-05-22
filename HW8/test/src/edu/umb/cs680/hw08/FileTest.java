package edu.umb.cs680.hw08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {
    private String[] stringArrayToCompare(File f) {
        Optional<Directory> optionalDirectory = Optional.ofNullable(f.getParent());
        String[] fileInfo = { Boolean.toString(f.isDirectory()), f.getName(),
                Integer.toString(f.getSize()), f.getCreationTime().toString(),
                optionalDirectory.isPresent()?f.getParent().getName():null};
        return fileInfo;
    }
    static LocalDateTime localTime = LocalDateTime.now();

    @SuppressWarnings("unused")
    @BeforeAll
    public static void directoryAndFileCreation() {
        Directory root = new Directory(null, "root", 0, localTime);
        Directory applications = new Directory(root, "applications", 0, localTime);
        Directory home = new Directory(root, "home", 0, localTime);
        Directory code = new Directory(home, "code", 0, localTime);
        File a = new File(applications, "a", 1300, localTime);
        File b = new File(applications, "b", 350, localTime);
        File c = new File(home, "c", 500, localTime);
        File d = new File(home, "d", 700, localTime);
        File e = new File(code, "e", 70, localTime);
        File f = new File(code, "f", 130, localTime);
        FileSystem.getFileSystem().appendRootDir(root);
    }


    @Test
    public void verifyFileEqualityA() {
        FileSystem f = FileSystem.getFileSystem();
        String[] expected = { "false", "a", "1300", localTime.toString(), "applications" };
        File actual = f.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(0);
        assertArrayEquals(expected,stringArrayToCompare(actual));
    }

    @Test
    public void verifyFileEqualityB() {
        FileSystem f = FileSystem.getFileSystem();
        String[] expected = { "false", "b", "350", localTime.toString(), "applications" };
        File actual = f.getRootDirs().get(0).getSubDirectories().get(0).getFiles().get(1);
        assertArrayEquals(expected,stringArrayToCompare(actual));
    }

    @Test
    public void verifyFileEqualityC() {
        FileSystem f = FileSystem.getFileSystem();
        String[] expected = { "false", "c", "500", localTime.toString(), "home" };
        File actual = f.getRootDirs().get(0).getSubDirectories().get(1).getFiles().get(0);
        assertArrayEquals(expected,stringArrayToCompare(actual));
    }

    @Test
    void TestForDirectoryRoot() {
        FileSystem f = FileSystem.getFileSystem();
        assertTrue(f.getRootDirs().get(0).isDirectory());
    }
}