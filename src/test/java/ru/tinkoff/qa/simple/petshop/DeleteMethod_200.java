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

public class DeleteMethod_200 {

    @Test
    @Order(1)
    public void postInMethodDelete200() {
        PetPost myPet2 = new PetPost();
        myPet2.setId(11);
        myPet2.setName("Kuzya11");
        Category category = new Category();
        myPet2.setCategory(category);
        myPet2.setStatus("available11");

        RestAssured.given()
                .contentType(ContentType.JSON)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .body(myPet2)
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .assertThat()
                .body("name", equalTo("Kuzya11"))
                .body("status", equalTo("available11"));
    }


    @Test
    @Order(2)
    public void firstGetInMethodDelete200() {
        RestAssured.when()
                .get("https://petstore.swagger.io/v2/pet/11")
                .then()
                .statusCode(200)
                .assertThat()
                .body("name", equalTo("Kuzya11"));
    }

    @Test
    @Order(3)
    public void delInMethodDelete200() {
        RestAssured.when()
                .delete("https://petstore.swagger.io/v2/pet/11")
                .then()
                .statusCode(200)
                .assertThat();
    }

    @Test
    @Order(4)
    public void secondGetInMethodDelete200() {
        RestAssured.when()
                .get("https://petstore.swagger.io/v2/pet/11")
                .then()
                .statusCode(404)
                .assertThat()
                .body("name", equalTo(null));
    }
}