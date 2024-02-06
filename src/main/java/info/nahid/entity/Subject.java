package info.nahid.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.*;


@Entity
public class Subject {
    @Id
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Min(value = 10, message = "Passing mark should be at least 10")
    private int passingMark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassingMark() {
        return passingMark;
    }

    public void setPassingMark(int passingMark) {
        this.passingMark = passingMark;
    }

    @Override
    public String toString() {
        return String.format("Subject[%s]",name);
    }
}
