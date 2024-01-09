package info.nahid.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject {
    //id , name, passing mark
    @Id
    private Long id;
    private String name;
    private int passingMark;
}
