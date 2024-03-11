package info.nahid.controller;

import info.nahid.entity.Subject;
import info.nahid.service.SubjectService;
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

@WebMvcTest(SubjectController.class)
public class SubjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    SubjectService subjectService;

    @Test
    public void testGetAllSubject() throws Exception {
        when(subjectService.getAllSubject()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/subjects"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void testAddSubject() throws Exception {
        doNothing().when(subjectService).addSubject(any(Subject.class));
        mockMvc.perform(post("/subjects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 30003}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Save subject successfully"));
    }

    @Test
    public void testUpdateSubject() throws Exception {
        doNothing().when(subjectService).updateSubject(any(Long.class), any(Subject.class));

        mockMvc.perform(put("/subjects/{id}", 30002)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 30003}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Update subject successfully"));
    }

    @Test
    public void testDeleteSubject() throws Exception {
        doNothing().when(subjectService).deleteSubject(any(Long.class));

        mockMvc.perform(delete("/subjects/{id}", 30004))
                .andExpect(status().isOk())
                .andExpect(content().string("Delete subject successfully"));
    }
}