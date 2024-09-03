package ru.daniel.javatgchatgpt.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.daniel.javatgchatgpt.TelegramBot;

@Configuration
public class TelegramBotConfiguration {

    @Value("${tg.bot.client.token}")
    private String botToken;

    @Bean
    @SneakyThrows
    public TelegramBot telegramBot(
            String botToken,
            TelegramBotsApi telegramBotsApi
    ) {

        var botOptions = new DefaultBotOptions();
        var bot = new TelegramBot(botOptions, botToken);

        telegramBotsApi.registerBot(bot);

        return bot;
    }

    @Bean
    @SneakyThrows
    public TelegramBotsApi telegramBotsApi() {
        return new TelegramBotsApi(DefaultBotSession.class);
    }

    @Bean
    public DefaultBotOptions defaultBotOptions() {
        return new DefaultBotOptions();
    }

    @Bean
    public String botToken() {
        return botToken;
    }
}
