package info.nahid.entity;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    private Long id;
    private String name;
    @Column(unique = true)
    private int rollNumber;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("Student[%s %d]",name, rollNumber);
    }
}
