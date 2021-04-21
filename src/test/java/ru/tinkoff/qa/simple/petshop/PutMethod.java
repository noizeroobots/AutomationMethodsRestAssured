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
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class PutMethod {

    @Test
    @Order(1)
    public void postInMethodPut200() {
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
                .extract()
                .as(PetPost.class);
        System.out.println(myPet2);
    }


    @Test
    @Order(2)
    public void firstGetInMethodPut200() {
        RestAssured.when()
                .get("https://petstore.swagger.io/v2/pet/11")
                .then()
                .statusCode(200)
                .extract()
                .as(PetPost.class);
    }

    @Test
    @Order(3)
    public void putInMethodPut200() {
        PetPost myChangedPet = new PetPost();
        myChangedPet.setId(11);
        myChangedPet.setName("Kuzya11+1");
        Category categoryChanged = new Category();
//        myChangedPet.setCategory(categoryChanged);
//        myChangedPet.setStatus("available11+1");

        RestAssured.given()
                .contentType(ContentType.JSON)
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter())
                .body(myChangedPet)
                .when()
                .put("https://petstore.swagger.io/v2/pet")
                .then()
                .statusCode(200);
//                .extract()
//                .as(PetPost.class);
        System.out.println(myChangedPet);
    }

    @Test
    @Order(4)
    public void getInMethodPut200() {
        RestAssured.when()
                .get("https://petstore.swagger.io/v2/pet/11")
                .then()
                .statusCode(200)
                .extract()
                .as(PetPost.class);
    }
}
