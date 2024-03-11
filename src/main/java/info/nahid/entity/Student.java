package info.nahid.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Min(value = 1900, message = "Year must be at least 1900")
    private int year;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @NotNull(message = "Department is mandatory")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    @NotEmpty(message = "Name cannot be empty")
    private Semester semester;
}
