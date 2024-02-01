package info.nahid.controller;

import info.nahid.entity.Subject;
import info.nahid.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @GetMapping("/subject")
    public List<Subject> getAllSubject() {
        return subjectService.getAllSubject();
    }

    @GetMapping("/subject/{id}")
    public Subject getDepartment(@PathVariable Long id) {
        return subjectService.getSubject(id);
    }

    @PostMapping("/subject")
    public String addSubject(@RequestBody Subject subject) {
        subjectService.addSubject(subject);
        return "Save subject successfully";
    }

    @PutMapping("/subject/{id}")
    public String updateSubject(@RequestBody Subject subject, @PathVariable Long id) {
        subjectService.updateSubject(id, subject);
        return "Update subject successfully";
    }

    @DeleteMapping("/subject/{id}")
    public String deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
        return "Delete subject successfully";
    }

}
