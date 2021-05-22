package edu.umb.cs680.hw10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class APFSTest {

    static LocalDateTime localTime = LocalDateTime.of(2020, 05, 20, 0, 0);
    private String[] stringarraycreation(APFSDirectory directory) {
        Optional<APFSDirectory> optionalDirectory = Optional.ofNullable(directory.getParent());
        String[] inforofdirectory = { Boolean.toString(directory.isDirectory()), directory.getName(),
                Integer.toString(directory.getSize()), directory.getCreationTime().toString(),
                optionalDirectory.isPresent()?directory.getParent().getName():null,
                Integer.toString(directory.getTotalSize()),
                Integer.toString(directory.countChildren()), directory.getOwnerName(),directory.getLastModified().toString()};
        return inforofdirectory;
    }
    @BeforeAll
    public static void setupupoffilestructure() {

        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        FilesystemofApfs.initFileSystem("drive", 3500);
    }



    @Test
    public void testrootmaindirectory() {
        APFS FilesystemofApfs = APFS.getAPFSFileSystem();
        APFSDirectory root = (APFSDirectory)FilesystemofApfs.getRootDir();
        String[] expected = { "true", "root", "0", localTime.toString(), null, "0", "0", "Ishan", localTime.toString() };
        APFSDirectory actual = root.findByName_Directory("root");
        assertArrayEquals(expected,stringarraycreation(actual));
    }

}