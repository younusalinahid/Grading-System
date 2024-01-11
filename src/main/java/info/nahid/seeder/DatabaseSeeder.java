package info.nahid.seeder;

import info.nahid.entity.Department;
import info.nahid.entity.Semester;
import info.nahid.entity.Student;
import info.nahid.entity.Subject;
import info.nahid.repository.DepartmentRepository;
import info.nahid.repository.SemesterRepository;
import info.nahid.repository.StudentRepository;
import info.nahid.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Component
public class DatabaseSeeder {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    SemesterRepository semesterRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedDepartment();
        seedStudentData();
        seedSubjectData();
        seedSemestersData();
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

    public void seedSubjectData() {
        List<Subject> subjects = new ArrayList<>();

        Subject subject1 = new Subject();
        subject1.setId(30001L);
        subject1.setName("Introduction to Programming");
        subject1.setPassingMark(100);
        subjects.add(subject1);

        Subject subject2 = new Subject();
        subject2.setId(30002L);
        subject2.setName("Database Management Systems");
        subject2.setPassingMark(100);
        subjects.add(subject2);
        subjectRepository.saveAll(subjects);
    }

    public void seedSemestersData() {
        for(int i = 1; i <= 12; i++) {
            Semester semester = new Semester();
            semester.setId((long)(40000 + i));
            semester.setName("Semester " + i);
            semesterRepository.save(semester);
        }
    }

    public void seedStudentData() {
        List<Student> students = new ArrayList<>();

        Department department1 = departmentRepository.findById(20001L).orElse(null);
        Semester semester1 = semesterRepository.findById(40001L).orElse(null);
        Student student1 = new Student();
        student1.setId(10001L);
        student1.setName("Naimul Islam");
        student1.setRollNumber(01);
        student1.setGender("Male");
        student1.setSemester(semester1);
        student1.setDepartment(department1);
        student1.setCompletedBachelor(true);
        students.add(student1);

        Student student3 = new Student();
        student3.setId(10003L);
        student3.setName("Md Khaled");
        student3.setRollNumber(03);
        student3.setCompletedBachelor(false);
        student3.setGender("Male");
        student3.setSemester(semester1);
        student3.setDepartment(department1);
        students.add(student3);

        Student student4 = new Student();
        student4.setId(10002L);
        student4.setName("Md Khaled");
        student4.setRollNumber(02);
        student4.setCompletedBachelor(true);
        student4.setSemester(semester1);
        student4.setGender("Male");
        student4.setDepartment(department1);
        students.add(student4);

        Department department2 = departmentRepository.findById(20002L).orElse(null);
        Semester semester2 = semesterRepository.findById(40002L).orElse(null);
        Student student2 = new Student();
        student2.setId(10004L);
        student2.setName("Rasedul hok");
        student2.setRollNumber(01);
        student2.setGender("Male");
        student2.setDepartment(department2);
        student2.setSemester(semester2);
        students.add(student2);
        student2.setCompletedBachelor(false);
        studentRepository.saveAll(students);

    }

}
