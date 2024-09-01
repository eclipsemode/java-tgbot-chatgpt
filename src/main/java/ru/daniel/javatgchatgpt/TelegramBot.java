package ru.daniel.javatgchatgpt;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramBot extends TelegramLongPollingBot {

    public TelegramBot(DefaultBotOptions options, String botToken) {
        super(options, botToken);
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            String chatId = update.getMessage().getChatId().toString();
            SendMessage sendMessage = new SendMessage(chatId, message);
            sendApiMethod(sendMessage);
        }
    }

    @Override
    public String getBotUsername() {
        return "chatgpt";
    }
}
