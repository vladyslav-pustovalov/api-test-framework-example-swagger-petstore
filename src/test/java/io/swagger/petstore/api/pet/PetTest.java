package io.swagger.petstore.api.pet;

import com.github.javafaker.Faker;
import io.swagger.petstore.api.pet.assertion.ResponseExpectedMessage;
import io.swagger.petstore.api.pet.controller.PetController;
import io.swagger.petstore.api.pet.model.Category;
import io.swagger.petstore.api.pet.model.PetDTO;
import io.swagger.petstore.api.pet.model.Status;
import io.swagger.petstore.api.pet.model.Tag;
import io.swagger.petstore.api.pet.util.BaseSpecification;
import org.junit.jupiter.api.*;

import java.util.Collections;

public class PetTest {
    PetController petController = new PetController();
    Faker faker = new Faker();

    @BeforeAll
    static void init() {
        BaseSpecification.installSpecifications();
    }

    @Test()
    @DisplayName("Add a new pet to the store via API")
    void testCreateNewPetWithAPI() {
        PetDTO targetPet = PetDTO.builder()
                .id(faker.number().randomDigit())
                .name(faker.name().name())
                .category(Category.builder().id(faker.number().randomDigit()).name(faker.name().name()).build())
                .photoUrls(Collections.singletonList(faker.name().name()))
                .tags(Collections.singletonList(Tag.builder().id(faker.number().randomDigit()).name(faker.name().name()).build()))
                .status(Status.randomStatus().getValue())
                .build();

        petController.addNewPetToStore(targetPet)
                .statusCodeIsEqualTo(ResponseExpectedMessage.StatusCode.OK)
                .responseIsEqualTo(targetPet);

        petController.findPetById(targetPet.getId())
                .statusCodeIsEqualTo(ResponseExpectedMessage.StatusCode.OK)
                .responseIsEqualTo(targetPet);
    }

    @AfterAll
    static void tearDown() {
    }
}
