package ru.pasvitas.telegrambotteaching.commands;

import java.util.Random;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;

public class RandomNumberCommand extends BotCommand {
    @Override
    public void executeCommand(String chatId, Message message, TelegramLongPollingBot bot) {
        Random random = new Random();
        int randomNumber = random.nextInt();


        sendMessage(chatId, "Случайное число: " + randomNumber, bot);
    }

    @Override
    public String getCommandName() {
        return "рандом";
    }
}
