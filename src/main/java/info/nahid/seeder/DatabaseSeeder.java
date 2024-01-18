package info.nahid.seeder;

import info.nahid.entity.Result;
import info.nahid.entity.*;
import info.nahid.repository.*;
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
    SubjectRepository subjectRepository;

    @Autowired
    SemesterRepository semesterRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ResultRepository resultRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedDepartment();
        seedStudentData();
        seedSubjectData();
        seedSemestersData();
        seedStudentResult();
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

        Subject subject3 = new Subject();
        subject3.setId(30003L);
        subject3.setName("Mathematics");
        subject3.setPassingMark(100);
        subjects.add(subject3);

        Subject subject4 = new Subject();
        subject4.setId(30004L);
        subject4.setName("English");
        subject4.setPassingMark(100);
        subjects.add(subject4);

        Subject subject5 = new Subject();
        subject5.setId(30005L);
        subject5.setName("Chemistry");
        subject5.setPassingMark(100);
        subjects.add(subject5);
        subjectRepository.saveAll(subjects);
    }

    public void seedSemestersData() {
        for (int i = 1; i <= 12; i++) {
            Semester semester = new Semester();
            semester.setId((long) (40000 + i));
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

        Student student2 = new Student();
        student2.setId(10002L);
        student2.setName("Rasedul hok");
        student2.setRollNumber(02);
        student2.setGender("Male");
        student2.setDepartment(department1);
        student2.setSemester(semester1);
        students.add(student2);
        student2.setCompletedBachelor(true);

        Student student3 = new Student();
        student3.setId(10003L);
        student3.setName("Hridoy Ahmed");
        student3.setRollNumber(03);
        student3.setCompletedBachelor(false);
        student3.setGender("Male");
        student3.setSemester(semester1);
        student3.setDepartment(department1);
        students.add(student3);


        Department department2 = departmentRepository.findById(20002L).orElse(null);
        Semester semester2 = semesterRepository.findById(40002L).orElse(null);
        Student student4 = new Student();
        student4.setId(10004L);
        student4.setName("Md Khaled");
        student4.setRollNumber(02);
        student4.setCompletedBachelor(true);
        student4.setSemester(semester2);
        student4.setDepartment(department2);
        student4.setGender("Male");
        students.add(student4);
        studentRepository.saveAll(students);
    }

    public void seedStudentResult() {
        List<Result> results = new ArrayList<>();

        Student student1 = studentRepository.findById(10001L).orElse(null);
        Subject subject1 = subjectRepository.findById(30001L).orElse(null);
        Subject subject2 = subjectRepository.findById(30002L).orElse(null);
        Semester semester1 = semesterRepository.findById(40001L).orElse(null);
        Semester semester2 = semesterRepository.findById(40002L).orElse(null);
        Result result1 = new Result();
        result1.setId(50001L);
        result1.setMarks(70);
        result1.setGrade("A");
        result1.setGPA(4.00);
        result1.setStudent(student1);
        result1.setSubject(subject1);
        result1.setSemester(semester1);
        results.add(result1);

        Student student2 = studentRepository.findById(10002L).orElse(null);
        Result result2 = new Result();
        result2.setId(50002L);
        result2.setMarks(88);
        result2.setGrade("A+");
        result2.setGPA(5.00);
        result2.setStudent(student2);
        result2.setSemester(semester1);
        result2.setSubject(subject1);
        results.add(result2);

        Student student3 = studentRepository.findById(10003L).orElse(null);
        Result result3 = new Result();
        result3.setId(50003L);
        result3.setMarks(30);
        result3.setGrade("F");
        result3.setGPA(0.00);
        result3.setStudent(student3);
        result3.setSemester(semester1);
        result3.setSubject(subject1);
        results.add(result3);

        Result result5 = new Result();
        result5.setId(50005L);
        result5.setMarks(87);
        result5.setGrade("A+");
        result5.setGPA(5.00);
        result5.setStudent(student1);
        result5.setSemester(semester2);
        result5.setSubject(subject2);
        results.add(result5);

        Result result6 = new Result();
        result6.setId(50006L);
        result6.setMarks(75);
        result6.setGPA(4.00);
        result6.setGrade("A");
        result6.setStudent(student2);
        result6.setSemester(semester2);
        result6.setSubject(subject2);
        results.add(result6);

        Student student4 = studentRepository.findById(10004L).orElse(null);
        Subject subject = subjectRepository.findById(30004L).orElse(null);
        Result result4 = new Result();
        result4.setId(50004L);
        result4.setMarks(76);
        result4.setGrade("A");
        result4.setGPA(4.00);
        result4.setStudent(student4);
        result4.setSemester(semester1);
        result4.setSubject(subject);
        results.add(result4);

        resultRepository.saveAll(results);
    }
}
