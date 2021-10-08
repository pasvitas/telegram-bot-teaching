package ru.pasvitas.telegrambotteaching.commands;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;

public class SaveCommand implements CommandExcutor {
    @Override
    public String getCommandName() {
        return null;
    }

    @Override
    public void executeCommand(String chatId, Message message, TelegramLongPollingBot bot) {

    }
}
