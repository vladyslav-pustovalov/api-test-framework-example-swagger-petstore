package io.swagger.petstore.api.pet;

import com.github.javafaker.Faker;
import io.swagger.petstore.api.pet.controller.PetController;
import io.swagger.petstore.api.pet.models.Category;
import io.swagger.petstore.api.pet.models.PetDTO;
import io.swagger.petstore.api.pet.models.Status;
import io.swagger.petstore.api.pet.models.Tag;
import io.swagger.petstore.api.pet.util.BaseSpecification;
import org.junit.jupiter.api.*;

import java.util.Collections;

public class PetTest {
    PetController petController = new PetController();
    Faker faker = new Faker();

    @BeforeEach
    void init() {
        BaseSpecification.installSpecifications();
    }

    @Test()
    @DisplayName("Add a new pet to the store via API")
    void createPet() {
        PetDTO targetPet = PetDTO.builder()
                .id(faker.number().randomDigit())
                .name(faker.name().name())
                .category(Category.builder().id(faker.number().randomDigit()).name(faker.name().name()).build())
                .photoUrls(Collections.singletonList(faker.name().name()))
                .tags(Collections.singletonList(Tag.builder().id(faker.number().randomDigit()).name(faker.name().name()).build()))
                .status(Status.randomStatus())
                .build();

        var petDTO = petController.addNewPetToStore(targetPet);
        var petDT2 = petController.findPetById(targetPet.getId());

        Assertions.assertEquals(petDTO.as(PetDTO.class), petDT2.as(PetDTO.class));
    }
}
