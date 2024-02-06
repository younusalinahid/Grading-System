package info.nahid.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    @Id
    private Long Id;

    @Min(value = 0, message = "Marks should not be less than 0")
    @Max(value = 100, message = "Marks should not be greater than 100 ")
    private int Marks;

    @DecimalMin(value = "0.0", message = "GPA should not be less than 0.0")
    @DecimalMax(value = "5.0", message = "GPA should not be greater than 4.0")
    private double GPA;
    private String Grade;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    @NotEmpty(message = "Semester cannot be empty")
    private Semester semester;

    @ManyToOne
    @JoinColumn(name = "Student_id")
    @NotEmpty(message = "Student cannot be empty")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    @NotEmpty(message = "Subject cannot be empty")
    private Subject subject;

    @DecimalMin(value = "0.0", message = "Semester CGPA should not be less than 0.0")
    @DecimalMax(value = "4.0", message = "Semester CGPA should not be greater than 4.0")
    private double semesterCGPA;
    private String semesterGrad;
}
