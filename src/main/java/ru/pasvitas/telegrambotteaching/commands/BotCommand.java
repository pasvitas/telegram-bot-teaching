package ru.pasvitas.telegrambotteaching.commands;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public abstract class BotCommand implements CommandExcutor {

    protected void sendMessage(String chatId, String message, TelegramLongPollingBot bot) {
        SendMessage sendMessage = new SendMessage(); // Create a SendMessage object with mandatory fields
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);

        try {
            bot.execute(sendMessage); // Call method to send the message
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
