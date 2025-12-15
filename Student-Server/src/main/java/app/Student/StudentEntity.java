package app.Student;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "STUD")
public class StudentEntity {

    @Id
    @Column(name = "ROLLNO")
    private int rollno;

    @Column(name = "SNAME")
    private String sname;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "BDAY")
    private Date bday;   

    @Column(name = "MARKS")
    private double marks;

    @Column(name = "DEPTNO")
    private int deptno;

    // ===== Getters & Setters =====

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBday() {
        return bday;
    }

    public void setBday(Date bday) {
        this.bday = bday;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }
}
