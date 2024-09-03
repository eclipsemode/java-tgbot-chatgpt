//package ru.daniel.javatgchatgpt.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import ru.daniel.javatgchatgpt.clients.YandexApiClient;
//
//@Configuration
//public class YandexApiConfig {
//
//    @Bean
//    public YandexApiClient yandexApiClient(
////            @Value("${tg.bot.client.token}") String botToken,
////            RestTemplateBuilder restTemplateBuilder,
////            @Value("${tg.bot.api.secret-key}") String secretKey,
////            @Value("${tg.bot.api.folder-id}") String folderId,
////            @Value("${tg.bot.api.url}") String url,
////            @Value("${tg.bot.api.modelUri}") String modelUri
//    ) {
//        return new YandexApiClient();
////        return new YandexApiClient(botToken, restTemplateBuilder.build(), secretKey, folderId, url, modelUri);
//    }
//}
