package io.swagger.petstore.api.pet.assertions;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.stream.Stream;

@AllArgsConstructor
public class ResponseExpectedMessage {
    private final Response targetResponse;

    public String expectedStatusCode(StatusCode expectedStatusCode) {
        return String.format("""
                Expected status code: %s
                
                Actual status code: %s
                
                Actual response bode: %s
                
                """, expectedStatusCode.code, targetResponse.statusCode(), targetResponse.body().asString());
    }

    public String expectedResponseBodyClass(Class expectedClass) {
        return String.format("""
                Unexpected response body: %s
                
                Expected body type: %s
                
                With fields: %s
                """, targetResponse.asString(), expectedClass.getSimpleName(), Arrays.toString(expectedClass.getDeclaredFields()));
    }

    @AllArgsConstructor
    @ToString
    public enum StatusCode {
        OK(200), CREATED(201);

        public final int code;

        public static StatusCode byValue(int value) {
            return Stream.of(StatusCode.values())
                    .filter(code -> code.code == value).findFirst()
                    .orElseThrow(() -> new RuntimeException(String.format("""
                    No such status code known %s
                    """, value)));
        }
    }
}
