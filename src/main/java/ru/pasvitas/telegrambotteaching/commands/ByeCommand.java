package ru.pasvitas.telegrambotteaching.commands;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;

public class ByeCommand extends BotCommand {

    @Override
    public String getCommandName() {
        return "пока";
    }

    @Override
    public void executeCommand(String chatId, Message message, TelegramLongPollingBot bot) {
        sendMessage(chatId, "Пока, " + message.getFrom().getFirstName(), bot);
    }
}
