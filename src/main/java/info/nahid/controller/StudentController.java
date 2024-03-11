package info.nahid.controller;

import info.nahid.dto.ResultDTo;
import info.nahid.dto.StudentInfoDto;
import info.nahid.entity.Student;
import info.nahid.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
    @PostMapping("/create")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student student1 = studentService.addStudent(student);
        return ResponseEntity.ok(student1);
    }

    @PutMapping("/{id}")
    public String updateStudent(@RequestBody Student student, @PathVariable Long id) {
        studentService.updateStudent(id, student);
        return "Update student successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Delete student successfully";
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
