package edu.umb.cs680.hw08;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class FileSystemTest {
    private String[] stringArrayForTheDirectory(Directory dir){
        String[] stringElement = {null, dir.getName(), Integer.toString(dir.getSize()), dir.getCreationTime().toString()};
        return stringElement;
    }

    @Test
    void testFileSystemInstance() {
        FileSystem f1 = FileSystem.getFileSystem();
        FileSystem f2 = FileSystem.getFileSystem();
        assertSame(f1, f2);
    }

    @Test
    void testRootDirectory() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Directory root = new Directory(null, "root", 0, localDateTime);
        String[] expected = {null, "root", "0", localDateTime.toString()};
        FileSystem.getFileSystem().appendRootDir(root);
        Directory actual = FileSystem.getFileSystem().getRootDirs().get(0);
        assertArrayEquals(expected, stringArrayForTheDirectory(actual));
    }

}