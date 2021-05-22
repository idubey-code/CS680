package edu.umb.cs680.hw10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class APFSFileCrawlingVisitorTest {

    static LocalDateTime localTime = LocalDateTime.of(2020, 05, 20, 0, 0);
    private String[] arraystringfordirectory(ArrayList<APFSFile> files) {
        String[] filesInDir = new String[files.size()];
        int i = 0;
        for(APFSFile f : files) {
            filesInDir[i] = f.getName();
            i++;
        }
        return filesInDir;
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
    void checkFilesUnderHome() {
        APFSFileCrawlingVisitor visitor = new APFSFileCrawlingVisitor();
        APFS APFSFileSystem = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)APFSFileSystem.getRootDir();
        APFSDirectory home = root.findByName_Directory("home");
        home.accept(visitor);
        String[] expected = {"e","f","c","d"};
        ArrayList<APFSFile> actual= visitor.getFiles();
        assertArrayEquals(expected,arraystringfordirectory(actual));
    }




    @Test
    void test_Files_Root() {
        APFSFileCrawlingVisitor visitor = new APFSFileCrawlingVisitor();
        APFS APFSFileSystem = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)APFSFileSystem.getRootDir();
        root.accept(visitor);
        String[] expected = {"a","b","e","f","c","d"};
        ArrayList<APFSFile> actual= visitor.getFiles();
        assertArrayEquals(expected,arraystringfordirectory(actual));
    }

    @Test
    void test_Files_Applcations() {
        APFSFileCrawlingVisitor visitor = new APFSFileCrawlingVisitor();
        APFS APFSFileSystem = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)APFSFileSystem.getRootDir();
        APFSDirectory system = root.findByName_Directory("applications");
        system.accept(visitor);
        String[] expected = {"a","b"};
        ArrayList<APFSFile> actual= visitor.getFiles();
        assertArrayEquals(expected,arraystringfordirectory(actual));
    }


    @Test
    void test_Files_Code() {
        APFSFileCrawlingVisitor visitor = new APFSFileCrawlingVisitor();
        APFS APFSFileSystem = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)APFSFileSystem.getRootDir();
        APFSDirectory pictures = root.findByName_Directory("code");
        pictures.accept(visitor);
        String[] expected = {"e","f"};
        ArrayList<APFSFile> actual= visitor.getFiles();
        assertArrayEquals(expected,arraystringfordirectory(actual));
    }



}