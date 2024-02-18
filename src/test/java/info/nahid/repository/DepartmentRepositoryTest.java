package info.nahid.repository;

import info.nahid.entity.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class DepartmentRepositoryTest {

    @Autowired
    DepartmentRepository departmentRepository;

    @Test
    public void findById_DepartmentPresent() {
        departmentRepository.findById(20001L)
                .ifPresent(department -> assertEquals("Computer Science", department.getName()));
    }

    @Test
    public void departmentUpdateTest() {
        Optional<Department> departmentOptional = departmentRepository.findById(20001L);
        if (departmentOptional.isPresent()) {
            Department department = departmentOptional.get();
            department.setName("Updated Department");
            departmentRepository.save(department);

            Optional<Department> updatedDepartmentOptional = departmentRepository.findById(20001L);
            assertTrue(updatedDepartmentOptional.isPresent());

            assertEquals("Updated Department", updatedDepartmentOptional.get().getName());
        }
    }

    @Test
    public void deleteById() {
        Optional<Department> departmentOptional = departmentRepository.findById(20001L);
        if (departmentOptional.isPresent())
            departmentRepository.deleteById(20001L);
        assertFalse(departmentRepository.findById(20001L).isPresent());
    }

}
