package info.nahid.service;

import info.nahid.entity.Department;
import info.nahid.entity.Student;
import info.nahid.repository.DepartmentRepository;
import info.nahid.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockTest {

    @Mock
    StudentRepository studentRepository;

    @Mock
    DepartmentRepository departmentRepository;

    @InjectMocks
    StudentService studentService;

    @InjectMocks
    DepartmentService departmentService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetStudentById() {
        Long studentId = 10001L;
        Student student = new Student();
        student.setId(studentId);
        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
        Student result1 = studentService.getStudentById(studentId);
        assertEquals(student, result1);
    }

    @Test
    public void testGetDepartmentById() {
        Long departmentId = 20001L;
        Department department = new Department();
        department.setId(departmentId);
        when(departmentRepository.findById(departmentId)).thenReturn(Optional.of(department));
        Department result2 = departmentService.getDepartment(departmentId);
        assertEquals(department, result2);
    }
}
