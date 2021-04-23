package ru.tinkoff.qa.simple.petshop;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import n.Category;
import n.PetPost;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.hamcrest.CoreMatchers.equalTo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class PutMethod_404 {

    @Test
    @Order(1)
    public void deleteInMethodPut404() {
        RestAssured.when()
                .delete("https://petstore.swagger.io/v2/pet/11")
                .then()
                .statusCode(200)
                .assertThat();
    }

    @Test
    @Order(2)
    public void putInMethodPut404() {
        PetPost myChangedPet = new PetPost();
        myChangedPet.setId(11);
        myChangedPet.setName("Kuzya11+1");
        Category categoryChanged = new Category();
        myChangedPet.setCategory(categoryChanged);
        myChangedPet.setStatus("available11+1");

        RestAssured.given()
                .contentType(ContentType.JSON)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .body(myChangedPet)
                .when()
                .put("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(404)
                .assertThat()
                .body("name",equalTo("Kuzya11+1"))
                .body("status",equalTo("available11+1"));
    }
}
