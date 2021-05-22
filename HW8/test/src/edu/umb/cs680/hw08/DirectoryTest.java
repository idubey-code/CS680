package edu.umb.cs680.hw08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    static LocalDateTime localTime = LocalDateTime.now();

    @SuppressWarnings("unused")
    @BeforeAll
    public static void setupFileStructure() {
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
        //creation of files and adding root dir
        FileSystem.getFileSystem().appendRootDir(root);

    }

    private String[] dirToStringArray(Directory d) {
        Optional<Directory> optionalDirectory = Optional.ofNullable(d.getParent());
        String[] directorystring = { Boolean.toString(d.isDirectory()), d.getName(),
                Integer.toString(d.getSize()), d.getCreationTime().toString(),
                optionalDirectory.isPresent()?d.getParent().getName():null,
                Integer.toString(d.getTotalSize()),
                Integer.toString(d.countChildren())};
        return directorystring;
    }

    @Test
    public void verifyDirectoryEqualityHome() {
        FileSystem f = FileSystem.getFileSystem();
        String[] expected = { "true", "home", "0", localTime.toString(), "root", "1400", "3" };
        Directory actual = f.getRootDirs().get(0).getSubDirectories().get(1);
        assertArrayEquals(expected,dirToStringArray(actual));

    }

    @Test
    public void verifyDirectorySize(){
        FileSystem f = FileSystem.getFileSystem();
        int actual = f.getRootDirs().get(0).getTotalSize();
        int expected = 3050;
        assertEquals(expected,actual);
    }

}