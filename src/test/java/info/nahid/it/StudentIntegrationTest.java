package info.nahid.it;

import info.nahid.repository.SemesterRepository;
import info.nahid.repository.StudentRepository;
import org.json.JSONException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
//    public void studentIntegration() throws JSONException {
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> request = new HttpEntity<>(headers);
//        ResponseEntity<String> response = restTemplate.exchange("/students", HttpMethod.GET, request, String.class);
//        assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
//    }

//    @Test
//    public void contextLoads() throws JSONException{
//        String response = this.restTemplate.getForObject("/students", String.class);
//        JSONAssert.assertEquals("[{id:10001}]",response, false);
//    }

//    @Test
//    public void testAllItemsFromDatabaseEndpoint() throws JSONException {
//        // Assuming you have a Semester entity available in your database
//        Semester semester = new Semester(); // Initialize Semester as needed
//        Student student = new Student();
//        student.setSemester(semester); // Set the Semester for the Student
//        studentRepository.save(student); // Save the Student entity to the database
//
//        // Make a GET request to the endpoint
//        String response = restTemplate.getForObject("http://localhost:" + port + "/students", String.class);
//
//        // Assert the response using JSONAssert
//        JSONAssert.assertEquals("[{\"id\":10001},{\"id\":10002},{\"id\":10003}]", response, false);
//    }
}