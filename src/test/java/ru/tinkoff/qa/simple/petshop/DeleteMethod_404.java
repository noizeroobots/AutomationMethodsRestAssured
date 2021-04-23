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

public class DeleteMethod_404 {

    @Test
    @Order(1)
    public void getInMethodDelete404() {
        RestAssured.when()
                .get("https://petstore.swagger.io/v2/pet/1134343")
                .then()
                .statusCode(404)
                .assertThat()
                .body("name", equalTo(null));
    }

    @Test
    @Order(2)
    public void deleteInMethodDelete404() {
        RestAssured.when()
                .delete("https://petstore.swagger.io/v2/pet/1134343")
                .then()
                .statusCode(404)
                .assertThat();
    }

}
