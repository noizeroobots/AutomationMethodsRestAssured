package ru.tinkoff.qa.simple.petshop;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import n.Category;
import n.PetPost;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class PutMethod_404 {

    @Test
    @Order(1)
    public void deleteInMethodPut404() {
        RestAssured.when()
                .delete("https://petstore.swagger.io/v2/pet/20215")
                .then()
                .statusCode(404)
                .assertThat();
    }

    @Test
    @Order(2)
    public void putInMethodPut404() {
        PetPost myChangedPet = new PetPost();
        myChangedPet.setId(20215);
        myChangedPet.setName("Brown Bear");
        Category categoryChanged = new Category();
        myChangedPet.setCategory(categoryChanged);
        myChangedPet.setStatus("jumps");

        RestAssured.given()
                .contentType(ContentType.JSON)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .body(myChangedPet)
                .when()
                .put("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(404)
                .assertThat();
    }
}
