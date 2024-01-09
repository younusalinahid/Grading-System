package info.nahid.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Semester {
    //id,name;
    @Id
    private Long id;
    private String name;

}
