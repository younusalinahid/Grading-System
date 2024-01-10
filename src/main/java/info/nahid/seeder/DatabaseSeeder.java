package info.nahid.seeder;

import info.nahid.entity.Department;
import info.nahid.entity.Student;
import info.nahid.repository.DepartmentRepository;
import info.nahid.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedDepartment();
        seedStudentData();
    }

    public void seedDepartment() {
        List<Department> departments = new ArrayList<>();

        Department department1 = new Department();
        department1.setId(20001L);
        department1.setName("Computer Science");
        departments.add(department1);

        Department department2 = new Department();
        department2.setId(20002L);
        department2.setName("Electrical Engineering");
        departments.add(department2);
        departmentRepository.saveAll(departments);
    }

    public void seedStudentData() {
        List<Student> students = new ArrayList<>();

        Department department1 = departmentRepository.findById(20001L).orElse(null);
        Student student1 = new Student();
        student1.setId(10001L);
        student1.setName("Younus Ali");
        student1.setRollNumber(01);
        student1.setDepartment(department1);
        students.add(student1);

        Department department2 = departmentRepository.findById(20002L).orElse(null);
        Student student2 = new Student();
        student2.setId(10002L);
        student2.setName("Rasedul hok");
        student2.setRollNumber(02);
        student2.setDepartment(department2);
        students.add(student2);
        studentRepository.saveAll(students);
    }

}
