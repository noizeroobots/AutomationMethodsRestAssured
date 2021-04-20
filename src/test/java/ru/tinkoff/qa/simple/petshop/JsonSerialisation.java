package ru.tinkoff.qa.simple.petshop;

import n.Category;
import n.PetPost;
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

        ObjectMapper
    }
}
