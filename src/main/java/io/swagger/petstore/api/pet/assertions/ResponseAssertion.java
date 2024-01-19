package io.swagger.petstore.api.pet.assertions;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;

@AllArgsConstructor
public class ResponseAssertion {
    private final Response targetResponse;

    public ResponseAssertion statusCodeIsEqualTo(ResponseExpectedMessage.StatusCode expectedStatusCode) {
        var statusCodeAssertionMessage = new ResponseExpectedMessage(targetResponse)
                .expectedStatusCode(expectedStatusCode);

        Assertions.assertThat(targetResponse.statusCode())
                .withFailMessage(statusCodeAssertionMessage)
                .isEqualTo(expectedStatusCode.code);
        return this;
    }

    public <T> T bindAs(Class<T> expectedClass) {
        T convertedObject;

        try {
            convertedObject = targetResponse.as(expectedClass);
        } catch (Exception e) {
            var assertionMessage = new ResponseExpectedMessage(targetResponse)
                    .expectedResponseBodyClass(expectedClass);
            throw new AssertionError(assertionMessage);
        }
        return convertedObject;
    }

    public void responseIsEqualTo(Object expectedObject) {
        var objectUnderTest = bindAs(expectedObject.getClass());

        Assertions.assertThat(objectUnderTest).isEqualTo(expectedObject);
    }
}
