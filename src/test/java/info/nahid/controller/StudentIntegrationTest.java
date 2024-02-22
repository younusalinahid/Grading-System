package info.nahid.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

//    @Test
//    public void contextLoads() throws JSONException {
//        Semester semester1 = semesterRepository.findById(40001L).orElse(null);
//        Student student = new Student();
//        student.setSemester(semester1);
//        studentRepository.save(student);
//
//        String response = this.restTemplate.getForObject("http://localhost:" + port + "/students", String.class);
//        String expectedJson = "[{\"id\":10001},{\"id\":10002},{\"id\":10003},{\"id\":10004},{\"id\":10005}]";
//        JSONAssert.assertEquals(expectedJson, response, false);
//    }

//    @Test
//    public void getAllStudentsTest() throws Exception {
//        // Mock the service to return some predefined students
//        when(studentService.getStudentsByDepartmentAndSemester()).thenReturn(List.of(new Student(10001), new Student(10002), new Student(10003)));
//
//        // Perform GET request to the endpoint and verify the response
//        mockMvc.perform((RequestBuilder) get("/students"))
//                .andExpect(status().isOk())
//                .andExpect((ResultMatcher) content().json("[{\"id\":10001},{\"id\":10002},{\"id\":10003}]"));
//    }

//    @Test
//    public void contextLoads() throws JSONException {
//        String response = this.restTemplate.getForObject("http://localhost:" + port + "/students", String.class);
//        String expectedJson = "[{\"id\":10001},{\"id\":10002},{\"id\":10003},{\"id\":10004},{\"id\":10005}]";
//        JSONAssert.assertEquals(expectedJson, response, false);
//    }

//    @Test
//    public void contextLoads() throws JSONException{
//        String response = this.restTemplate.getForObject("/students", String.class);
//        JSONAssert.assertEquals("[{id:10001},{id:10002},{id:10003},{id:10004},{id:10005}]",response, false);
//    }

    @Test
    public void testGetAllStudents() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/students", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Add more assertions to validate the response body
    }
}