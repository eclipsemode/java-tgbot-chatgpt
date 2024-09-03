package ru.daniel.javatgchatgpt.clients;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

//@Component
public class YandexApiClient {

    @Value("${tg.bot.client.token}")
    private String botToken;

    private final RestTemplate restTemplate = new RestTemplateBuilder().build();

    @Value("${tg.bot.api.secret-key}")
    private String secretKey;

    @Value("${tg.bot.api.folder-id}")
    private String folderId;

    @Value("${tg.bot.api.url}")
    private String url;

    @Value("${tg.bot.api.modelUri}")
    private String modelUri;

    public ChatCompletionObject createChatCompletion(
            String message
    ) {
        HttpHeaders httpHeaders = new HttpHeaders();

        String request = """
                {
                  "modelUri": "%s",
                  "completionOptions": {
                    "stream": false,
                    "temperature": 0.6,
                    "maxTokens": "2000"
                  },
                  "messages": [
                    {
                      "role": "user",
                      "text": "%s"
                    }
                  ]
                }
                """.formatted(modelUri, message);

        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Api-Key " + secretKey);
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        headers.put("x-folder-id", folderId);

        httpHeaders.setAll(headers);

        HttpEntity<String> httpEntity = new HttpEntity<>(request, httpHeaders);

        ResponseEntity<ChatCompletionObject> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                httpEntity,
                ChatCompletionObject.class
        );

        return responseEntity.getBody();
    }
}
