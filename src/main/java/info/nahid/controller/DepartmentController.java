package info.nahid.controller;

import info.nahid.entity.Department;
import info.nahid.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDepartment() {
        return departmentService.getAllDepartment();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartment(@PathVariable Long id) {
        return departmentService.getDepartment(id);
    }

    @PostMapping(value = "/departments/create")
    public String addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
        return "Save department successfully";
    }

    @PutMapping("/departments/{id}")
    public String updateDepartment(@RequestBody Department department, @PathVariable Long id) {
        departmentService.updateDepartment(id, department);
        return "Update department successfully";
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return "Delete department successfully";
    }

}
