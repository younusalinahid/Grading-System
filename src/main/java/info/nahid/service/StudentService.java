package info.nahid.service;

import info.nahid.dto.ResultDTo;
import info.nahid.dto.StudentInfoDto;
import info.nahid.entity.Result;
import info.nahid.entity.Student;
import info.nahid.repository.DepartmentRepository;
import info.nahid.repository.ResultRepository;
import info.nahid.repository.SemesterRepository;
import info.nahid.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    SemesterRepository semesterRepository;

   @Autowired
   ResultRepository resultRepository;

    public List<Student> getStudentsByDepartmentAndSemester() {
        return studentRepository.findAll();
    }

    public List<StudentInfoDto> getAllStudentsInfo() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private StudentInfoDto convertToDto(Student student) {
        StudentInfoDto dto = new StudentInfoDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setGander(student.getGender());
        dto.setDepartment(student.getDepartment().getName());
        dto.setCurrentSemester(student.getSemester().getName());
        dto.setCompletedBachelor(student.isCompletedBachelor());
        return dto;
    }

    public List<ResultDTo> getStudentResults() {
        List<Result> results = resultRepository.findAll();
        return results.stream()
                .map(this::mapToResultDTo)
                .collect(Collectors.toList());
    }

    private ResultDTo mapToResultDTo(Result result) {
        ResultDTo resultDTo = new ResultDTo();
        resultDTo.setId(result.getId());
        resultDTo.setMarks(result.getMarks());
        resultDTo.setGrade(result.getGrade());
        resultDTo.setGPA(result.getGPA());
        resultDTo.setSubject(result.getSubject().getName());
        resultDTo.setStudent(result.getStudent().getName());
        resultDTo.setSemester(result.getSemester().getName());
        resultDTo.setSemesterCGPA(result.getSemesterCGPA());
        resultDTo.setSemesterGrad(result.getSemesterGrad());
        return resultDTo;
    }

}
