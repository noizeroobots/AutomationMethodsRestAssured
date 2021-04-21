package ru.tinkoff.qa.simple.petshop;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import n.Category;
import n.PetPost;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetMethod {

    @Test
    public void postGet200() {
        PetPost myPet = new PetPost();
        myPet.setId(1);
        myPet.setName("Kuzya");
        Category category = new Category();
        myPet.setCategory(category);
        myPet.setStatus("available");

        RestAssured.given()
                .contentType(ContentType.JSON)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .body(myPet)
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .extract()
                .as(PetPost.class);

        RestAssured.when()
                .get("https://petstore.swagger.io/v2/pet/1")
                .then()
                .statusCode(200);
    }
}
