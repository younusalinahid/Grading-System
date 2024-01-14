package info.nahid.controller;

import info.nahid.dto.ResultDTo;
import info.nahid.dto.StudentInfoDto;
import info.nahid.entity.Student;
import info.nahid.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getStudentsByDepartmentAndSemester();
    }

    @GetMapping("/info")
    public List<StudentInfoDto> getAllStudentInfo() {
        return studentService.getAllStudentsInfo();
    }

    @GetMapping("/result")
    public List<ResultDTo> getStudentResults() {
        return studentService.getStudentResults();
    }

}
