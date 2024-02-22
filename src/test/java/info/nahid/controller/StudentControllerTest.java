package info.nahid.controller;

import java.util.Collections;
import info.nahid.entity.Student;
import info.nahid.service.DepartmentService;
import info.nahid.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    StudentService studentService;

    @MockBean
    DepartmentService departmentService;

    @Test
    public void testGetAllStudents() throws Exception {
        when(studentService.getStudentsByDepartmentAndSemester()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testAddStudent() throws Exception {
        doNothing().when(studentService).addStudent(any(Student.class));
        mockMvc.perform(post("/students/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 10006}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Student adding successfully"));
    }

    @Test
    public void testUpdateStudent() throws Exception {
        doNothing().when(studentService).updateStudent(any(Long.class), any(Student.class));

        mockMvc.perform(put("/students/{id}", 10006)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 10006}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Update student successfully"));
    }

    @Test
    public void testDeleteStudent() throws Exception {
        doNothing().when(studentService).deleteStudent(any(Long.class));

        mockMvc.perform(delete("/students/{id}", 10006))
                .andExpect(status().isOk())
                .andExpect(content().string("Delete student successfully"));
    }

    @Test
    public void testGetAllStudentInfo() throws Exception {
        when(studentService.getAllStudentsInfo()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/students/info"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testGetStudentResults() throws Exception {
        when(studentService.getStudentResults()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/students/result"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}