package info.nahid.it;

import info.nahid.entity.Department;
import info.nahid.entity.Semester;
import info.nahid.entity.Student;
import info.nahid.repository.SemesterRepository;
import info.nahid.repository.StudentRepository;
import org.json.JSONException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:";
    HttpHeaders headers;

    @Test
    public void createStudents() {
        Department department = new Department(20001L, "Computer Science");
        Semester semester = new Semester(40001L, "Semester 1");
        Student student = new Student(10001L, "Younus Ali", 4, true, "Male", 2024, department, semester);


        HttpEntity<Student> request = new HttpEntity<>(student, headers);
        ResponseEntity<Void> result = restTemplate.postForEntity(BASE_URL + port + "/students/create", request, Void.class);
        assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
    }


    @Test
    public void getStudents() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange("/students", HttpMethod.GET, request, String.class);
        assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
    }

//    @Test
//    public void createStudents() {
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> request = new HttpEntity<>(headers);
//        ResponseEntity<String> response = restTemplate.exchange("/students", HttpMethod.POST, request, String.class);
//        assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
//    }


//    @Test
//    public void createPostSuccess() {
//        PostCreateRequest post = new PostCreateRequest("Title 1", "Description for Title 1", 1);
//        HttpEntity<PostCreateRequest> request = new HttpEntity<>(post, headers);
//        ResponseEntity<ObjectResponse> result = restTemplate.postForEntity(BASE_URL , request, ObjectResponse.class);
//        assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
//    }

}