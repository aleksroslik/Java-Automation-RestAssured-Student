import Base.BaseTest;
import DataFactory.StudentFactory;
import Model.Student;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StudentApiTest extends BaseTest {

    String student = """
            {
                "name" : "Maria"
                "surname" : "Malinowska"
                "nationality" : "UK"
                "age" : "25"
            """;

    Student studentObject = new StudentFactory().getStudent();
    Student randomStudent = new StudentFactory().getRandomStudent();

    @Test
    public void shouldCreateNewStudentFromMap() {
        Map<String, Object> studentMap = new HashMap<>();
        studentMap.put("name", "Jan");
        studentMap.put("surname", "Kowalski");
        studentMap.put("nationality", "Poland");
        studentMap.put("age", 30);
        String total = RestAssured.
                given()
                .spec(getRequestSpec())
                .body(studentMap)
                .when()
                .post()
                .then()
                .statusCode(201)
                .extract()
                .path("total");
        assertThat(total).as("wrong total number").isEqualTo("10");
    }

    @Test
    public void shouldCreateNewStudentFromObject() {
        String total = RestAssured.
                given()
                .spec(getRequestSpec())
                .body(studentObject)
                .when()
                .post()
                .then()
                .statusCode(201)
                .extract()
                .path("total");
        assertThat(total).as("wrong total number").isEqualTo("10");
    }

    @Test
    public void shouldCreateNewRandomStudentBuilder() {
        String total = RestAssured.
                given()
                .spec(getRequestSpec())
                .body(randomStudent)
                .when()
                .post()
                .then()
                .statusCode(201)
                .extract()
                .path("total");
        assertThat(total).as("wrong total number").isEqualTo("10");
    }

    @Test
    public void shouldCreateNewStudentFromVariable() {
        String total = RestAssured.
                given()
                .spec(getRequestSpec())
                .body(student)
                .when()
                .post()
                .then()
                .statusCode(201)
                .extract()
                .path("total");
        assertThat(total).as("wrong total number").isEqualTo("10");
    }
}
