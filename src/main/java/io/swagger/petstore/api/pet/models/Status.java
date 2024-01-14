package io.swagger.petstore.api.pet.models;

import com.github.javafaker.Faker;
import lombok.Getter;

import java.util.Random;

@Getter
public enum Status {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold");

    private String value;

    Status(String value) {
        this.value = value;
    }

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
