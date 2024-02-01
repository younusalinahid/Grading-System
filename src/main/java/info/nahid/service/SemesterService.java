package info.nahid.service;

import info.nahid.entity.Semester;
import info.nahid.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SemesterService {

    @Autowired
    SemesterRepository semesterRepository;

    public List<Semester> getAllSemester() {
        return semesterRepository.findAll();
    }

    public Semester getSemester(Long id) {
        Optional<Semester> semester = semesterRepository.findById(id);
        return semester.orElse(null);
    }

    public void addSemester(Semester semester) {
        semesterRepository.save(semester);
    }

    public void updateSemester(Long id, Semester semester) {
        semesterRepository.save(semester);
    }

    public void deleteSemester(Long id) {
        semesterRepository.deleteById(id);
    }

}
