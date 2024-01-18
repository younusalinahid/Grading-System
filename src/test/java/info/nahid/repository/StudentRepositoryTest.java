package info.nahid.repository;
import info.nahid.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Test
    public void findById_StudentPresent() {
        studentRepository.findById(10001L).ifPresent(student -> assertEquals("Naimul Islam", student.getName()));

    }

    @Test
    public void retrieveDepartmentForStudent() {
        Student student = studentRepository.findById(10001L).orElse(null);
        logger.info("Student -> {}", student);
        if (student != null) {
            logger.info("Department -> {}", student.getDepartment());
        }
    }

    @Test
    public void retrieveSemesterForStudent() {
        Student student = studentRepository.findById(10001L).orElse(null);
        logger.info("Student -> {}", student);
        if (student != null) {
            logger.info("Semester -> {}", student.getSemester());
        }
    }
}
