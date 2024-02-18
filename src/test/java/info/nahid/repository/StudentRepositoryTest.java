package info.nahid.repository;
import info.nahid.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class StudentRepositoryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void findById_StudentPresent() {
        studentRepository.findById(10001L)
                .ifPresent(student -> assertEquals("Naimul Islam", student.getName()));
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

    @Test
    public void StudentUpdateTest() {
        Optional<Student> studentOptional = studentRepository.findById(10001L);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setName("Younus Ali");
            studentRepository.save(student);

            Optional<Student> updatedStudentOptional = studentRepository.findById(10001L);
            assertTrue(updatedStudentOptional.isPresent());

            assertEquals("Younus Ali", updatedStudentOptional.get().getName());
        }
    }

    @Test
    public void deleteById() {
        Optional<Student> studentOptional = studentRepository.findById(10001L);
        if (studentOptional.isPresent())
            studentRepository.deleteById(10003L);
        assertFalse(studentRepository.findById(10003L).isPresent());
    }
}
