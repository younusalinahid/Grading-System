package info.nahid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfoDto {

    @Id
    private Long id;
    private String name;
    private String department;
    private String gander;
    private boolean completedBachelor;
    private String currentSemester;

}
