package ru.daniel.javatgchatgpt.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Result {
    @JsonProperty("alternatives")
    private Alternatives[] alternatives;
}
