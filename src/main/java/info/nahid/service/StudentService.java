package info.nahid.service;

import info.nahid.entity.Department;
import info.nahid.entity.Semester;
import info.nahid.entity.Student;
import info.nahid.repository.DepartmentRepository;
import info.nahid.repository.SemesterRepository;
import info.nahid.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    SemesterRepository semesterRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentsByDepartmentAndSemester(Long departmentId, Long semesterId) {
        Department department = new Department();
        department.setId(departmentId);
        Semester semester = new Semester();
        semester.setId(semesterId);
        return studentRepository.findAll();
    }
}
