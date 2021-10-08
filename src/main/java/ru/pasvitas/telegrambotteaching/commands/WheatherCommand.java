package ru.pasvitas.telegrambotteaching.commands;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;

public class WheatherCommand extends BotCommand {
    @Override
    public String getCommandName() {
        return "погода";
    }

    @Override
    public void executeCommand(String chatId, Message message, TelegramLongPollingBot bot) {

    }
}
