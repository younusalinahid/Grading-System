package info.nahid.controller;

import info.nahid.entity.Semester;
import info.nahid.service.SemesterService;
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

@WebMvcTest(SemesterController.class)
public class SemesterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    SemesterService semesterService;

    @Test
    public void testGetAllSemester() throws Exception {
        when(semesterService.getAllSemester()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/semester"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testAddSemester() throws Exception {
        doNothing().when(semesterService).addSemester(any(Semester.class));
        mockMvc.perform(post("/semester")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 40003}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Save semester successfully"));
    }

    @Test
    public void testUpdateSemester() throws Exception {
        doNothing().when(semesterService).updateSemester(any(Long.class), any(Semester.class));

        mockMvc.perform(put("/semester/{id}", 20002)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 40003}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Update semester successfully"));
    }

    @Test
    public void testDeleteStudent() throws Exception {
        doNothing().when(semesterService).deleteSemester(any(Long.class));

        mockMvc.perform(delete("/semester/{id}", 40004))
                .andExpect(status().isOk())
                .andExpect(content().string("Delete semester successfully"));
    }
}