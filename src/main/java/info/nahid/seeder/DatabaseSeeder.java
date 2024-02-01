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

        Subject subject6 = new Subject();
        subject6.setId(30006L);
        subject6.setName("Data Structure");
        subject6.setPassingMark(100);
        subjects.add(subject6);

        Subject subject7 = new Subject();
        subject7.setId(30007L);
        subject7.setName("Discrete Mathematics");
        subject7.setPassingMark(100);
        subjects.add(subject7);

        Subject subject8 = new Subject();
        subject8.setId(30008L);
        subject8.setName("Calculus");
        subject8.setPassingMark(100);
        subjects.add(subject8);

        Subject subject9 = new Subject();
        subject9.setId(30009L);
        subject9.setName("Computer networks");
        subject9.setPassingMark(100);
        subjects.add(subject9);

        Subject subject10 = new Subject();
        subject10.setId(30010L);
        subject10.setName("Machine learning");
        subject10.setPassingMark(100);
        subjects.add(subject10);

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

        //Department of Electrical Engineering;
        Department department2 = departmentRepository.findById(20002L).orElse(null);
        Student student4 = new Student();
        student4.setId(10004L);
        student4.setName("Md Khaled");
        student4.setRollNumber(01);
        student4.setCompletedBachelor(true);
        student4.setSemester(semester1);
        student4.setDepartment(department2);
        student4.setGender("Male");
        students.add(student4);

        Student student5 = new Student();
        student5.setId(10005L);
        student5.setName("Md Khaled");
        student5.setRollNumber(02);
        student5.setCompletedBachelor(true);
        student5.setSemester(semester1);
        student5.setDepartment(department2);
        student5.setGender("Male");
        students.add(student5);
        studentRepository.saveAll(students);
    }

    public void seedStudentResult() {
        List<Result> results = new ArrayList<>();

        Student student1 = studentRepository.findById(10001L).orElse(null);
        Subject subject1 = subjectRepository.findById(30001L).orElse(null);
        Subject subject2 = subjectRepository.findById(30002L).orElse(null);
        Subject subject3 = subjectRepository.findById(30003L).orElse(null);
        Semester semester1 = semesterRepository.findById(40001L).orElse(null);

        Result result1 = new Result();
        result1.setId(50001L);
        result1.setMarks(70);
        result1.setGrade("A");
        result1.setGPA(4.00);
        result1.setStudent(student1);
        result1.setSubject(subject1);
        result1.setSemester(semester1);
        results.add(result1);

        Result result2 = new Result();
        result2.setId(50002L);
        result2.setMarks(80);
        result2.setGrade("A+");
        result2.setGPA(5.00);
        result2.setStudent(student1);
        result2.setSubject(subject2);
        result2.setSemester(semester1);
        results.add(result2);

        Result result3 = new Result();
        result3.setId(50003L);
        result3.setMarks(88);
        result3.setGrade("A+");
        result3.setGPA(5.00);
        result3.setStudent(student1);
        result3.setSubject(subject3);
        result3.setSemester(semester1);
        if (result1.getGPA() == 0.00 || result2.getGPA() == 0.00 || result3.getGPA() == 0.00) {
            result3.setSemesterCGPA(0.00);
        } else {
            double averageGPA3 = (result1.getGPA() + result2.getGPA() + result3.getGPA()) / 3.0;
            result3.setSemesterCGPA(Double.parseDouble(String.format("%.2f", averageGPA3)));
        }
        result3.setSemesterGrad("A");
        results.add(result3);

        Student student2 = studentRepository.findById(10003L).orElse(null);
        Result result4 = new Result();
        result4.setId(50004L);
        result4.setMarks(89);
        result4.setGrade("A+");
        result4.setGPA(5.00);
        result4.setStudent(student2);
        result4.setSemester(semester1);
        result4.setSubject(subject1);
        results.add(result4);

        Result result5 = new Result();
        result5.setId(50005L);
        result5.setMarks(88);
        result5.setGrade("A+");
        result5.setGPA(5.00);
        result5.setStudent(student2);
        result5.setSemester(semester1);
        result5.setSubject(subject2);
        results.add(result5);

        Result result6 = new Result();
        result6.setId(50006L);
        result6.setMarks(80);
        result6.setGrade("A+");
        result6.setGPA(5.00);
        result6.setStudent(student2);
        result6.setSemester(semester1);
        result6.setSubject(subject3);
        if (result4.getGPA() == 0.00 || result5.getGPA() == 0.00 || result6.getGPA() == 0.00) {
            result6.setSemesterCGPA(0.00);
        } else {
            double averageGPA2 = (result4.getGPA() + result5.getGPA() + result6.getGPA()) / 3.0;
            result6.setSemesterCGPA(Double.parseDouble(String.format("%.2f", averageGPA2)));
        }
        result6.setSemesterGrad("A+");
        results.add(result6);

        Student student3 = studentRepository.findById(10003L).orElse(null);
        Result result7 = new Result();
        result7.setId(50007L);
        result7.setMarks(30);
        result7.setGrade("F");
        result7.setGPA(0.00);
        result7.setStudent(student3);
        result7.setSemester(semester1);
        result7.setSubject(subject1);
        results.add(result7);

        Result result8 = new Result();
        result8.setId(50008L);
        result8.setMarks(66);
        result8.setGrade("A-");
        result8.setGPA(3.50);
        result8.setStudent(student3);
        result8.setSemester(semester1);
        result8.setSubject(subject2);
        results.add(result8);

        Result result9 = new Result();
        result9.setId(50009L);
        result9.setMarks(75);
        result9.setGPA(4.00);
        result9.setGrade("A");
        result9.setStudent(student3);
        result9.setSubject(subject3);
        result9.setSemester(semester1);
        if (result7.getGPA() == 0.00 || result8.getGPA() == 0.00 || result9.getGPA() == 0.00) {
            result9.setSemesterCGPA(0.00);
        } else {
            double averageGPA3 = (result7.getGPA() + result8.getGPA() + result9.getGPA()) / 3.0;
            result9.setSemesterCGPA(Double.parseDouble(String.format("%.2f", averageGPA3)));
        }
        result9.setSemesterGrad("F");
        results.add(result9);

        //second Semester for student
        Semester semester2 = semesterRepository.findById(40002L).orElse(null);
        Subject subject4 = subjectRepository.findById(30004L).orElse(null);
        Subject subject5 = subjectRepository.findById(30005L).orElse(null);
        Subject subject6 = subjectRepository.findById(30006L).orElse(null);
        Result result10 = new Result();
        result10.setId(50010L);
        result10.setMarks(77);
        result10.setGrade("A");
        result10.setGPA(4.00);
        result10.setStudent(student1);
        result10.setSubject(subject4);
        result10.setSemester(semester2);
        results.add(result10);

        Result result11 = new Result();
        result11.setId(50011L);
        result11.setMarks(85);
        result11.setGrade("A+");
        result11.setGPA(5.00);
        result11.setStudent(student1);
        result11.setSubject(subject5);
        result11.setSemester(semester2);
        results.add(result11);

        Result result12 = new Result();
        result12.setId(50012L);
        result12.setMarks(85);
        result12.setGrade("A+");
        result12.setGPA(5.00);
        result12.setStudent(student1);
        result12.setSubject(subject6);
        result12.setSemester(semester2);
        if (result10.getGPA() == 0.00 || result11.getGPA() == 0.00 || result12.getGPA() == 0.00) {
            result12.setSemesterCGPA(0.00);
        } else {
            double averageGPA3 = (result10.getGPA() + result11.getGPA() + result12.getGPA()) / 3.0;
            result12.setSemesterCGPA(Double.parseDouble(String.format("%.2f", averageGPA3)));
        }
        result12.setSemesterGrad("A");
        results.add(result12);

        Result result13 = new Result();
        result13.setId(50013L);
        result13.setMarks(82);
        result13.setGrade("A+");
        result13.setGPA(5.00);
        result13.setStudent(student2);
        result13.setSubject(subject4);
        result13.setSemester(semester2);
        results.add(result13);

        Result result14 = new Result();
        result14.setId(50014L);
        result14.setMarks(89);
        result14.setGrade("A+");
        result14.setGPA(5.00);
        result14.setStudent(student2);
        result14.setSubject(subject5);
        result14.setSemester(semester2);
        results.add(result14);

        Result result15 = new Result();
        result15.setId(50015L);
        result15.setMarks(90);
        result15.setGrade("A+");
        result15.setGPA(5.00);
        result15.setStudent(student2);
        result15.setSubject(subject6);
        result15.setSemester(semester2);
        if (result13.getGPA() == 0.00 || result14.getGPA() == 0.00 || result15.getGPA() == 0.00) {
            result15.setSemesterCGPA(0.00);
        } else {
            double averageGPA3 = (result13.getGPA() + result14.getGPA() + result15.getGPA()) / 3.0;
            result15.setSemesterCGPA(Double.parseDouble(String.format("%.2f", averageGPA3)));
        }
        result15.setSemesterGrad("A+");
        results.add(result15);
        resultRepository.saveAll(results);
    }
}
