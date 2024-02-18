package info.nahid.repository;

import info.nahid.entity.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SubjectRepositoryTest {

    @Autowired
    SubjectRepository subjectRepository;

    @Test
    public void findById() {
        subjectRepository.findById(30001L)
                .ifPresent(subject -> assertEquals("Introduction to Programming", subject.getName()));
    }

    @Test
    public void SubjectUpdateTest() {
        Optional<Subject> subjectOptional = subjectRepository.findById(30002L);
        if (subjectOptional.isPresent()) {
            Subject subject = subjectOptional.get();
            subject.setName("Updated Subject");
            subjectRepository.save(subject);

            Optional<Subject> updatedSubjectOptional = subjectRepository.findById(30002L);
            assertTrue(updatedSubjectOptional.isPresent());

            assertEquals("Updated Subject", updatedSubjectOptional.get().getName());
        }
    }

    @Test
    public void deleteById() {
        Optional<Subject> subjectOptional = subjectRepository.findById(30003L);
        if (subjectOptional.isPresent())
            subjectRepository.deleteById(30003L);
        assertFalse(subjectRepository.findById(30003L).isPresent());
    }

}