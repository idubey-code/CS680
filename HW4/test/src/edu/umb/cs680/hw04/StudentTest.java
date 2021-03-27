package edu.umb.cs680.hw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    public void createInStateStudentTest(){
        Student student = Student.createInStateStudent("Mark","Dorchester");
        float expectedTuition = 5000;
        float tuition = student.getTuition();
        String expectedName = "Mark";
        String name = student.getName();
        int expectedI20num = 0;
        int i20num = student.getI20num();
        String expectedUsAddr = "Dorchester";
        String usAddr = student.getUsAddr();
        int expectedYrsInState = 0;
        int yrsInState = student.getYrsInState();
        String expectedForeignAddr = "NA";
        String foreignAddr = student.getForeignAddr();
        StudentStatus expectedStatus = StudentStatus.INSTATE;
        StudentStatus status = student.getStatus();

        assertEquals(expectedTuition,tuition);
        assertEquals(expectedName,name);
        assertEquals(expectedI20num,i20num);
        assertEquals(expectedUsAddr,usAddr);
        assertEquals(expectedYrsInState,yrsInState);
        assertEquals(expectedForeignAddr,foreignAddr);
        assertEquals(expectedStatus,status);
    }

    @Test
    public void createOutStateStudentTest(){
        Student student = Student.createOutStateStudent("Paul","Sacramento",5);
        float expectedTuition = 7000;
        float tuition = student.getTuition();
        String expectedName = "Paul";
        String name = student.getName();
        int expectedI20num = 0;
        int i20num = student.getI20num();
        String expectedUsAddr = "Sacramento";
        String usAddr = student.getUsAddr();
        int expectedYrsInState = 5;
        int yrsInState = student.getYrsInState();
        String expectedForeignAddr = "NA";
        String foreignAddr = student.getForeignAddr();
        StudentStatus expectedStatus = StudentStatus.OUTSTATE;
        StudentStatus status = student.getStatus();

        assertEquals(expectedTuition,tuition);
        assertEquals(expectedName,name);
        assertEquals(expectedI20num,i20num);
        assertEquals(expectedUsAddr,usAddr);
        assertEquals(expectedYrsInState,yrsInState);
        assertEquals(expectedForeignAddr,foreignAddr);
        assertEquals(expectedStatus,status);
    }

    @Test
    public void createIntlStateStudentTest(){
        Student student = Student.createIntlStudent("Ishan","Quincy",31794,"Delhi");
        float expectedTuition = 12000;
        float tuition = student.getTuition();
        String expectedName = "Ishan";
        String name = student.getName();
        int expectedI20num = 31794;
        int i20num = student.getI20num();
        String expectedUsAddr = "Quincy";
        String usAddr = student.getUsAddr();
        int expectedYrsInState = 0;
        int yrsInState = student.getYrsInState();
        String expectedForeignAddr = "Delhi";
        String foreignAddr = student.getForeignAddr();
        StudentStatus expectedStatus = StudentStatus.INTL;
        StudentStatus status = student.getStatus();

        assertEquals(expectedTuition,tuition);
        assertEquals(expectedName,name);
        assertEquals(expectedI20num,i20num);
        assertEquals(expectedUsAddr,usAddr);
        assertEquals(expectedYrsInState,yrsInState);
        assertEquals(expectedForeignAddr,foreignAddr);
        assertEquals(expectedStatus,status);
    }

}