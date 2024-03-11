package info.nahid.controller;

import info.nahid.entity.Department;
import info.nahid.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DepartmentService departmentService;

    @Test
    public void testGetAllDepartment() throws Exception {
        when(departmentService.getAllDepartment()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/departments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testAddDepartment() throws Exception {
        doNothing().when(departmentService).addDepartment(any(Department.class));
        mockMvc.perform(post("/departments/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 20003}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Save department successfully"));
    }

    @Test
    public void testUpdateDepartment() throws Exception {
        doNothing().when(departmentService).updateDepartment(any(Long.class), any(Department.class));

        mockMvc.perform(put("/departments/{id}", 20002)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 10003}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Update department successfully"));
    }

    @Test
    public void testDeleteStudent() throws Exception {
        doNothing().when(departmentService).deleteDepartment(any(Long.class));

        mockMvc.perform(delete("/departments/{id}", 20004))
                .andExpect(status().isOk())
                .andExpect(content().string("Delete department successfully"));
    }
}