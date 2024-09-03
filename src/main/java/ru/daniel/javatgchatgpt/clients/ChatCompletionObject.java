package ru.daniel.javatgchatgpt.clients;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ChatCompletionObject {

    @JsonProperty("result")
    private Result result;
}
