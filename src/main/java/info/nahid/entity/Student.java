package info.nahid.entity;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Student {
    @Id
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Min(value = 1, message = "Roll number should be at least 1")
    private int rollNumber;
    private boolean completedBachelor;

    @NotBlank(message = "Gender is mandatory")
    private String gender;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @NotNull(message = "Department is mandatory")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    @NotEmpty(message = "Name cannot be empty")
    private Semester semester;
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

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public boolean isCompletedBachelor() {
        return completedBachelor;
    }

    public void setCompletedBachelor(boolean completedBachelor) {
        this.completedBachelor = completedBachelor;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("Student[%s %d]",name, rollNumber);
    }
}
