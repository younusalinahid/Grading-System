package info.nahid.service;

import info.nahid.dto.StudentInfoDto;
import info.nahid.entity.Department;
import info.nahid.entity.Semester;
import info.nahid.entity.Student;
import info.nahid.repository.DepartmentRepository;
import info.nahid.repository.SemesterRepository;
import info.nahid.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    SemesterRepository semesterRepository;

    public List<Student> getStudentsByDepartmentAndSemester() {
        //Department department = new Department();
        //department.setId(departmentId);
        //Semester semester = new Semester();
        //semester.setId(semesterId);
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
}
