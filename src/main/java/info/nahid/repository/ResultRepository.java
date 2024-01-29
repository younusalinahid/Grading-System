package info.nahid.repository;

import info.nahid.entity.Result;
import info.nahid.entity.Semester;
import info.nahid.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

    List<Result> findByStudentAndSemester(Student student, Semester semester);

}
