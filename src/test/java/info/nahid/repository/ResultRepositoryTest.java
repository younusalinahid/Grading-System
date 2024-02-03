package info.nahid.repository;
import info.nahid.entity.Department;
import info.nahid.entity.Result;
import info.nahid.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ResultRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ResultRepository resultRepository;

    @Test
    public void basicTest() {
        Student student = studentRepository.findById(10002L).orElse(null);
        if (student != null) {
            Department department = student.getDepartment();
            department.setName("Computer Science");
            student.setName("Naimur Islam - updated");
        }
    }

    @Test
    public void retrieveResultForStudent() {
        Result result = resultRepository.findById(50003L).orElse(null);
        logger.info("Result -> {}", result);
        if (result != null) {
            logger.info("Student -> {}", result.getStudent());
        }
    }

    @Test
    public void retrieveResultForSemester() {
        Result result = resultRepository.findById(50001L).orElse(null);
        logger.info("Result -> {}", result);
        if (result != null) {
            logger.info("Semester -> {}", result.getSemester());
        }
    }

    @Test
    public void retrieveResultForSubject() {
        Result result = resultRepository.findById(50002L).orElse(null);
        logger.info("Result -> {}", result);
        if (result != null) {
            logger.info("Subject -> {}", result.getSubject());
        }
    }
}
