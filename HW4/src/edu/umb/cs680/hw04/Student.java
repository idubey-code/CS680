package edu.umb.cs680.hw04;

enum StudentStatus{
    INSTATE, OUTSTATE, INTL;
}

public class Student {

    private float tuition;
    private String name;
    private int i20num;
    private String usAddr;
    private int yrsInState;
    private String foreignAddr;
    private StudentStatus status;


    private Student(float tuition, String name, int i20num, String usAddr, int yrsInState, String foreignAddr, StudentStatus status) {
        this.tuition = tuition;
        this.name = name;
        this.i20num = i20num;
        this.usAddr = usAddr;
        this.yrsInState = yrsInState;
        this.foreignAddr = foreignAddr;
        this.status = status;
    }

    public static final Student createInStateStudent(String name, String usAddr){
        return new Student(5000,name,0,usAddr,0,"NA",StudentStatus.INSTATE);
    }

    public static final Student createOutStateStudent(String name, String usAddr, int yrsInState){
        return new Student(7000,name,0,usAddr,yrsInState,"NA",StudentStatus.OUTSTATE);
    }

    public static final Student createIntlStudent(String name, String usAddr, int i20num, String foreignAddr){
        return new Student(12000,name,i20num,usAddr,0,foreignAddr,StudentStatus.INTL);
    }

    public float getTuition() {
        return tuition;
    }

    public String getName() {
        return name;
    }

    public int getI20num() {
        return i20num;
    }

    public String getUsAddr() {
        return usAddr;
    }

    public int getYrsInState() {
        return yrsInState;
    }

    public String getForeignAddr() {
        return foreignAddr;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public static void main(String[] args) {

    }
}
