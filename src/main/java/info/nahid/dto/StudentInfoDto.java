package info.nahid.dto;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfoDto {

    private Long id;
    private String name;
    private String department;
    private String gander;
    private String completedBachelor;
    private String currentSemester;

}
