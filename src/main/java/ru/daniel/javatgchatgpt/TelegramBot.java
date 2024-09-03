package ru.daniel.javatgchatgpt;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.daniel.javatgchatgpt.clients.YandexApiClient;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private final YandexApiClient yandexApiClient = new YandexApiClient();

    public TelegramBot(DefaultBotOptions options, String botToken) {
        super(options, botToken);
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();

            var chatCompletionRes = yandexApiClient.createChatCompletion(message);

            var textResponse = chatCompletionRes
                    .getResult()
                    .getAlternatives()[0]
                    .getMessage()
                    .getText();

            SendMessage sendMessage = new SendMessage(chatId, textResponse);
            sendApiMethod(sendMessage);
        }
    }

    @Override
    public String getBotUsername() {
        return "chatgpt";
    }
}
