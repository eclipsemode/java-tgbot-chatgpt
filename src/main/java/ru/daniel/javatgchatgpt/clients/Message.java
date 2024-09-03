package ru.daniel.javatgchatgpt.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Message {
    @JsonProperty("role")
    private String role;

    @JsonProperty("text")
    private String text;
}
