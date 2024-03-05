package info.nahid.service;
import info.nahid.entity.Department;
import info.nahid.entity.Semester;
import info.nahid.entity.Student;
import info.nahid.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void testGetStudentsByDepartmentAndSemester() {
        Department department = new Department();
        department.setId(20001L);
        department.setName("Computer Science");

        Semester semester = new Semester();
        semester.setId(40001L);
        semester.setName("Semester 3");

        Student student1 = new Student();
        student1.setId(10001L);
        student1.setName("Younus Ali");
        student1.setRollNumber(10);
        student1.setDepartment(department);
        student1.setSemester(semester);

        Student student2 = new Student();
        student2.setId(10002L);
        student2.setName("Nahid");
        student2.setRollNumber(2);
        student2.setDepartment(department);
        student2.setSemester(semester);

        List<Student> students = Arrays.asList(student1, student2);
        when(studentRepository.findAll()).thenReturn(students);
        List<Student> returnedStudents = studentService.getStudentsByDepartmentAndSemester();
        assertEquals(2, returnedStudents.size());
        assertEquals("Younus Ali", returnedStudents.get(0).getName());
        assertEquals("Nahid", returnedStudents.get(1).getName());
    }

    @Test
    public void testAddStudent() {
        Student student = new Student();
        student.setId(10003L);
        student.setName("Raisul Islam");
        student.setRollNumber(3);

        when(studentRepository.save(student)).thenReturn(student);
        studentService.addStudent(student);
        verify(studentRepository).save(student);
    }

    @Test
    public void testUpdateStudent() {
        Student student = new Student();
        student.setId(10002L);
        student.setName("John Doe");
        student.setRollNumber(20);

        studentService.updateStudent(10002L, student);
        verify(studentRepository).save(student);
    }

    @Test
    public void testDeleteStudent() {
        studentService.deleteStudent(10001L);
        verify(studentRepository).deleteById(10001L);
    }
}