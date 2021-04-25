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

public class DeleteMethod_200 {

    @Test
    @Order(1)
    public void postInMethodDelete200() {
        PetPost myPet2 = new PetPost();
        myPet2.setId(20216);
        myPet2.setName("Lion");
        Category category = new Category();
        myPet2.setCategory(category);
        myPet2.setStatus("roars");

        RestAssured.given()
                .contentType(ContentType.JSON)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .body(myPet2)
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .assertThat()
                .body("name", equalTo("Lion"))
                .body("status", equalTo("roars"));
    }

    @Test
    @Order(2)
    public void firstGetInMethodDelete200() {
        RestAssured.when()
                .get("https://petstore.swagger.io/v2/pet/20216")
                .then()
                .statusCode(200)
                .assertThat()
                .body("name", equalTo("Lion"))
                .body("status", equalTo("roars"));
    }

    @Test
    @Order(3)
    public void deleteInMethodDelete200() {
        RestAssured.when()
                .delete("https://petstore.swagger.io/v2/pet/20216")
                .then()
                .statusCode(200)
                .assertThat();
    }

    @Test
    @Order(4)
    public void secondGetInMethodDelete200() {
        RestAssured.when()
                .get("https://petstore.swagger.io/v2/pet/20216")
                .then()
                .statusCode(404)
                .assertThat()
                .body("name", equalTo(null))
                .body("status", equalTo(null));
    }
}
