package info.nahid.service;

import info.nahid.entity.Subject;
import info.nahid.repository.SubjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SubjectServiceTest {

    @Mock
    SubjectRepository subjectRepository;

    @InjectMocks
    SubjectService subjectService;

    @Test
    public void testGetAllSubject() {
        Subject subject1 = new Subject();
        subject1.setId(30001L);
        subject1.setName("Introduction to Programming");
        subject1.setPassingMark(100);

        Subject subject2 = new Subject();
        subject2.setId(30002L);
        subject2.setName("Database Management Systems");
        subject2.setPassingMark(100);

        List<Subject> subject = Arrays.asList(subject1, subject2);
        when(subjectRepository.findAll()).thenReturn(subject);
        List<Subject> returnedSubject = subjectService.getAllSubject();
        assertEquals(2, returnedSubject.size());
        assertEquals("Introduction to Programming", returnedSubject.get(0).getName());
        assertEquals("Database Management Systems", returnedSubject.get(1).getName());
    }

    @Test
    public void testAddSubject() {
        Subject subject = new Subject();
        subject.setId(30001L);
        subject.setName("Introduction to Programming");
        subject.setPassingMark(100);
        when(subjectRepository.save(subject)).thenReturn(subject);
        subjectService.addSubject(subject);
        verify(subjectRepository).save(subject);
    }

    @Test
    public void testUpdateSubject() {
        Subject subject = new Subject();
        subject.setId(30001L);
        subject.setName("Introduction to Programming");
        subject.setPassingMark(100);

        subjectService.updateSubject(30002L, subject);
        verify(subjectRepository).save(subject);
    }

    @Test
    public void testDeleteSubject() {
        subjectService.deleteSubject(30002L);
        verify(subjectRepository).deleteById(30002L);
    }
}