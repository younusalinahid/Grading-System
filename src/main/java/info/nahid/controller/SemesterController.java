package info.nahid.controller;

import info.nahid.entity.Semester;
import info.nahid.service.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SemesterController {

    @Autowired
    SemesterService semesterService;

    @GetMapping("/semesters")
    public List<Semester> getAllSemester() {
        return semesterService.getAllSemester();
    }

    @GetMapping("/semesters/{id}")
    public Semester getSemester(@PathVariable Long id) {
        return semesterService.getSemester(id);
    }

    @PostMapping(value = "/semesters/create")
    public String addSemester(@RequestBody Semester semester) {
        semesterService.addSemester(semester);
        return "Save semester successfully";
    }

    @PutMapping("/semesters/{id}")
    public String updateSemester(@RequestBody Semester semester, @PathVariable Long id) {
        semesterService.updateSemester(id, semester);
        return "Update semester successfully";
    }

    @DeleteMapping("/semesters/{id}")
    public String deleteSemester(@PathVariable Long id) {
        semesterService.deleteSemester(id);
        return "Delete semester successfully";
    }

}
