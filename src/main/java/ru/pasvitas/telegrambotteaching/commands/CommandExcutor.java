package ru.pasvitas.telegrambotteaching.commands;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface CommandExcutor {
    String getCommandName();
    void executeCommand(String chatId, Message message, TelegramLongPollingBot bot);
}
