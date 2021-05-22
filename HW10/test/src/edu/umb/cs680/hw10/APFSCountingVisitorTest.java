package edu.umb.cs680.hw10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class APFSCountingVisitorTest {

    static LocalDateTime localTime = LocalDateTime.of(2020, 05, 20, 0, 0);

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
    //count the visitors
    @Test
    void TestCountingVisitorvalue() {
        APFSCountingVisitor count_visitor = new APFSCountingVisitor();
        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
        root.accept(count_visitor);

        assertEquals(count_visitor.getDirNum(), 4);
        assertEquals(count_visitor.getFileNum(), 6);
        assertEquals(count_visitor.getLinkNum(), 2);
    }
    //testing code to check, need to remove later
    @Test
    void TestCountingVisitorvaluetry() {
        APFSCountingVisitor count_visitor = new APFSCountingVisitor();
        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
        root.accept(count_visitor);

        assertEquals(count_visitor.getDirNum(), 4);
        assertEquals(count_visitor.getFileNum(), 6);
        assertEquals(count_visitor.getLinkNum(), 2);
    }

}