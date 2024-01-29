package info.nahid.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTo {

    private Long Id;
    private int Marks;
    private double GPA;
    private String Grade;
    private String student;
    private String subject;
    private String Semester;
    private double semesterCGPA;
    private String semesterGrad;

}
