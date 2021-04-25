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

public class GetMethod_200 {

    @Test
    @Order(1)
    public void postInMethodGet200() {
        PetPost myPet2 = new PetPost();
        myPet2.setId(20211);
        myPet2.setName("Panda");
        Category category = new Category();
        myPet2.setCategory(category);
        myPet2.setStatus("eats");

        RestAssured.given()
                .contentType(ContentType.JSON)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .body(myPet2)
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .assertThat()
                .body("name",equalTo("Panda"))
                .body("status",equalTo("eats"));
    }


    @Test
    @Order(2)
    public void getInMethodGet200() {
        RestAssured.when()
                .get("https://petstore.swagger.io/v2/pet/20211")
                .then()
                .statusCode(200)
                .assertThat()
                .body("name",equalTo("Panda"))
                .body("status",equalTo("eats"));
    }
}
