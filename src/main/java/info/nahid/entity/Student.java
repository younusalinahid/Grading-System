package info.nahid.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    //id , name, rollNumber, department
    @Id
    private Long id;
    private String name;
    private int rollNumber;
    private String department;
}
