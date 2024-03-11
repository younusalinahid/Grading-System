package info.nahid.it;

import info.nahid.entity.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DepartmentIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:";
    HttpHeaders headers;

    @Test
    public void createDepartments() {
        Department department = new Department(20001L, "Computer Science");

        HttpEntity<Department> request = new HttpEntity<>(department);
        ResponseEntity<Void> result = restTemplate.postForEntity(BASE_URL + port + "/departments/create", request, Void.class);
        assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue());
    }

    @Test
    public void getDepartments() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange("/departments", HttpMethod.GET, request, String.class);
        assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
    }

    @Test
    public void updateDepartment() {
        Department department = new Department(20001L, "Computer Science");

        restTemplate.put(BASE_URL + port + "/departments/{id}", department, department.getId());

        Department updatedDepartment = restTemplate.getForObject(BASE_URL + port + "/departments/{id}", Department.class, department.getId());
        assertNotNull(updatedDepartment);
        assertEquals(20001L, updatedDepartment.getId());
        assertEquals("Computer Science", updatedDepartment.getName());
    }
    @Test
    public void deleteDepartment() {
        // Assume 20001L is the ID you want to delete
        Department department = new Department(20001L, "Computer Science");

        ResponseEntity<Void> deletionResponse = restTemplate.exchange(BASE_URL + port + "/departments/{id}",
                HttpMethod.DELETE, null, Void.class, department);

        assertEquals(HttpStatus.OK, deletionResponse.getStatusCode());
    }
}