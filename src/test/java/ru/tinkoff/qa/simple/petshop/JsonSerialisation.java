package ru.tinkoff.qa.simple.petshop;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.internal.common.assertion.Assertion;
import n.Category;
import n.PetPost;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerialisation {

    @Test
    public void test(){
        PetPost myPet = new PetPost();
        myPet.setId(1);
        myPet.setName("Kuzya");
        Category category = new Category();
        myPet.setCategory(category);
        myPet.setStatus("available");

        /* преобразование из JSON в объект */
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonPet = null;
        try {
            jsonPet = objectMapper.writeValueAsString(myPet);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonPet);

        /* преобразование из объекта в JSON */
        PetPost petAfterJson = null;
        try {
            petAfterJson = objectMapper.readValue(jsonPet, PetPost.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(myPet, petAfterJson);

    }
}
