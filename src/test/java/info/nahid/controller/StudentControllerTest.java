package info.nahid.controller;

import java.util.Collections;
import info.nahid.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    StudentService studentService;

    @Test
    public void testGetAllStudents() throws Exception {
        when(studentService.getStudentsByDepartmentAndSemester()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
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