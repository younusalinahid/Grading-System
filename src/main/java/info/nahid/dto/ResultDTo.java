package info.nahid.dto;

import info.nahid.entity.Semester;
import info.nahid.entity.Student;
import info.nahid.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


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
