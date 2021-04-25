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

public class PutMethod_200 {

    @Test
    @Order(1)
    public void postInMethodPut200() {
        PetPost myPet2 = new PetPost();
        myPet2.setId(20214);
        myPet2.setName("Black Bear");
        Category category = new Category();
        myPet2.setCategory(category);
        myPet2.setStatus("loves");

        RestAssured.given()
                .contentType(ContentType.JSON)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .body(myPet2)
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .assertThat()
                .body("name",equalTo("Black Bear"))
                .body("status",equalTo("loves"));
    }

    @Test
    @Order(2)
    public void firstGetInMethodPut200() {
        RestAssured.when()
                .get("https://petstore.swagger.io/v2/pet/20214")
                .then()
                .statusCode(200)
                .assertThat()
                .body("name",equalTo("Black Bear"))
                .body("status",equalTo("loves"));
    }

    @Test
    @Order(3)
    public void putInMethodPut200() {
        PetPost myChangedPet = new PetPost();
        myChangedPet.setId(20214);
        myChangedPet.setName("Black Bear");
        Category categoryChanged = new Category();
        myChangedPet.setCategory(categoryChanged);
        myChangedPet.setStatus("kills");

        RestAssured.given()
                .contentType(ContentType.JSON)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .body(myChangedPet)
                .when()
                .put("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200)
                .assertThat()
                .body("name",equalTo("Black Bear"))
                .body("status",equalTo("kills"));
    }

    @Test
    @Order(4)
    public void secondGetInMethodPut200() {
        RestAssured.when()
                .get("https://petstore.swagger.io/v2/pet/20214")
                .then()
                .statusCode(200)
                .assertThat()
                .body("name",equalTo("Black Bear"))
                .body("status",equalTo("kills"));
    }
}
