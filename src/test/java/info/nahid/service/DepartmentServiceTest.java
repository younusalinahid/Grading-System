package info.nahid.service;

import info.nahid.entity.Department;
import info.nahid.repository.DepartmentRepository;
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
public class DepartmentServiceTest {

    @Mock
    DepartmentRepository departmentRepository;

    @InjectMocks
    DepartmentService departmentService;

    @Test
    public void testGetAllDepartments() {
        Department department1 = new Department();
        department1.setId(20001L);
        department1.setName("Computer Science");

        Department department2 = new Department();
        department2.setId(20002L);
        department2.setName("Electrical Engineering");

        List<Department> departments = Arrays.asList(department1, department2);
        when(departmentRepository.findAll()).thenReturn(departments);
        List<Department> returnedDepartments = departmentService.getAllDepartment();
        assertEquals(2, returnedDepartments.size());
        assertEquals("Computer Science", returnedDepartments.get(0).getName());
        assertEquals("Electrical Engineering", returnedDepartments.get(1).getName());
    }

    @Test
    public void testAddDepartment() {
        Department department = new Department();
        department.setId(20003L);
        department.setName("BBA");
        when(departmentRepository.save(department)).thenReturn(department);
        departmentService.addDepartment(department);
        verify(departmentRepository).save(department);
    }

    @Test
    public void testUpdateDepartment() {
        Department department = new Department();
        department.setId(10002L);
        department.setName("Electrical Engineering");

        departmentService.updateDepartment(20002L, department);
        verify(departmentRepository).save(department);
    }

    @Test
    public void testDeleteDepartment() {
        departmentService.deleteDepartment(20001L);
        verify(departmentRepository).deleteById(20001L);
    }
}