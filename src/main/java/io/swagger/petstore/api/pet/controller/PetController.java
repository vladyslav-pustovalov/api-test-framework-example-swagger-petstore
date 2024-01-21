package io.swagger.petstore.api.pet.controller;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.swagger.petstore.api.pet.assertion.ResponseAssertion;
import io.swagger.petstore.api.pet.model.PetDTO;

import static io.restassured.RestAssured.given;

public class PetController {

    private RequestSpecification petStoreAPIClient() {
        return given();
    }

    public Response updateExistingPet(PetDTO petDTO) {
        return petStoreAPIClient()
                    .body(petDTO)
                .when()
                    .put();
    }

    @Step("Add a new pet to the store")
    public ResponseAssertion addNewPetToStore(PetDTO petDTO) {
        return new ResponseAssertion(petStoreAPIClient()
                    .body(petDTO)
                .when()
                    .post());
    }

    public Response findPetsByStatus() {
        return petStoreAPIClient()
                .when()
                    .get("/findByTags");
    }

    public Response findPetsByTags() {
        return petStoreAPIClient()
                .when()
                    .get("/findPetByTag");
    }

    @Step("Find a pet from the store by id")
    public ResponseAssertion findPetById(Integer id) {
        return new ResponseAssertion(petStoreAPIClient()
                .when()
                    .get(String.format("/%s", id)));
    }

    public Response updatePetWithFormData(String petId) {
        return petStoreAPIClient()
                .when()
                    .post(String.format("/%s", petId));
    }

    public Response deletePet(Integer id) {
        return petStoreAPIClient()
                .when()
                    .delete(String.format("/%s", id));
    }

    public Response uploadImage(Integer id) {
        return petStoreAPIClient()
                .when()
                    .post(String.format("/%s/uploadImage", id));
    }
}
