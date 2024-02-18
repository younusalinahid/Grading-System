package info.nahid.repository;

import info.nahid.entity.Semester;
import info.nahid.entity.Semester;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class SemesterRepositoryTest {

    @Autowired
    SemesterRepository semesterRepository;

    @Test
    public void findById_SemesterPresent() {
        semesterRepository.findById(40001L)
                .ifPresent(semester -> assertEquals("Semester1", semester.getName()));
    }

    @Test
    public void semesterUpdateTest() {
        Optional<Semester> semesterOptional = semesterRepository.findById(40002L);
        if (semesterOptional.isPresent()) {
            Semester semester = semesterOptional.get();
            semester.setName("Updated Semester");
            semesterRepository.save(semester);

            Optional<Semester> updatedSemesterOptional = semesterRepository.findById(40002L);
            assertTrue(updatedSemesterOptional.isPresent());

            assertEquals("Updated Semester", updatedSemesterOptional.get().getName());
        }
    }

    @Test
    public void deleteById() {
        Optional<Semester> semesterOptional = semesterRepository.findById(20001L);
        if (semesterOptional.isPresent())
            semesterRepository.deleteById(40005L);
        assertFalse(semesterRepository.findById(40005L).isPresent());
    }

}
