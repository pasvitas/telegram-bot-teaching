package ru.pasvitas.telegrambotteaching.commands;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;

public class HelloCommand extends BotCommand {

    @Override
    public String getCommandName() {
        return "привет";
    }

    @Override
    public void executeCommand(String chatId, Message message, TelegramLongPollingBot bot) {
        sendMessage(chatId, "Привет, " + message.getFrom().getFirstName(), bot);
    }
}
