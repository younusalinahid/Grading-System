package info.nahid.service;

import info.nahid.entity.Semester;
import info.nahid.repository.SemesterRepository;
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
public class SemesterServiceTest {

    @Mock
    SemesterRepository semesterRepository;

    @InjectMocks
    SemesterService semesterService;

    @Test
    public void testGetAllSemester() {
        Semester semester1 = new Semester();
        semester1.setId(40001L);
        semester1.setName("Semester 1");

        Semester semester2 = new Semester();
        semester2.setId(40002L);
        semester2.setName("Semester 2");

        List<Semester> semesters = Arrays.asList(semester1, semester2);
        when(semesterRepository.findAll()).thenReturn(semesters);
        List<Semester> returnedSemesters = semesterService.getAllSemester();
        assertEquals(2, returnedSemesters.size());
        assertEquals("Semester 1", returnedSemesters.get(0).getName());
        assertEquals("Semester 2", returnedSemesters.get(1).getName());
    }

    @Test
    public void testAddSemester() {
        Semester semester = new Semester();
        semester.setId(40003L);
        semester.setName("Semester 3");
        when(semesterRepository.save(semester)).thenReturn(semester);
        semesterService.addSemester(semester);
        verify(semesterRepository).save(semester);
    }

    @Test
    public void testUpdateSemester() {
        Semester semesters = new Semester();
        semesters.setId(40002L);
        semesters.setName("Semester Updated");

        semesterService.updateSemester(40002L, semesters);
        verify(semesterRepository).save(semesters);
    }

    @Test
    public void testDeleteSemester() {
        semesterService.deleteSemester(40001L);
        verify(semesterRepository).deleteById(40001L);
    }
}