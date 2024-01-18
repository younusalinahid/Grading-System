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
    private Double GPA;
    private String Grade;
    private String Semester;
    private String student;
    private String subject;
}
