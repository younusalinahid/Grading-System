package info.nahid.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
    //id, name
    @Id
    private Long id;
    private String name;
}
