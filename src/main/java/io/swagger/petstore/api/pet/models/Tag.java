package io.swagger.petstore.api.pet.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Tag {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
}