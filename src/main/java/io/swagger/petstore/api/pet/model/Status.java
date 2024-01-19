package io.swagger.petstore.api.pet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public enum Status {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold");

    private final String value;

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static Status fromValue(String text) {
        for (Status status: Status.values()) {
            if (String.valueOf(status.value).equals(text.toLowerCase())) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + text + "'");
    }

    public static Status randomStatus() {
        Status[] statuses = Status.values();
        return statuses[new Random().nextInt(statuses.length)];
    }
}
