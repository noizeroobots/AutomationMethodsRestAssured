package ru.tinkoff.qa.simple.petshop;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import n.Category;
import n.PetPost;
import org.junit.jupiter.api.*;
import static org.hamcrest.CoreMatchers.equalTo;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class PostMethod_200 {

    @Test
    @Order(1)
    public void postInMethodPost200() {
        PetPost myPet2 = new PetPost();
        myPet2.setId(20213);
        myPet2.setName("White Bear");
        Category category = new Category();
        myPet2.setCategory(category);
        myPet2.setStatus("sleeps");

        RestAssured.given()
                .contentType(ContentType.JSON)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .body(myPet2)
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .assertThat()
                .body("name",equalTo("White Bear"))
                .body("status",equalTo("sleeps"));
    }

    @Test
    @Order(2)
    public void getInMethodPost200() {
        RestAssured.when()
                .get("https://petstore.swagger.io/v2/pet/20213")
                .then()
                .statusCode(200)
                .assertThat()
                .body("name",equalTo("White Bear"))
                .body("status",equalTo("sleeps"));
    }
}
