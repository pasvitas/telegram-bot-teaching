package ru.pasvitas.telegrambotteaching.commands;

import java.util.Random;
import ru.pasvitas.telegrambotteaching.model.InputMessageInfo;
import ru.pasvitas.telegrambotteaching.model.SourceType;
import ru.pasvitas.telegrambotteaching.service.SendService;

public class RandomNumberCommand extends BotCommand {

    public RandomNumberCommand(SendService service) {
        super(service);
    }

    @Override
    public void executeCommand(InputMessageInfo inputMessageInfo, SourceType sourceType) {
        Random random = new Random();
        int randomNumber = random.nextInt();
        sendMessage(inputMessageInfo.getChannelId(), "Случайное число: " + randomNumber, sourceType);
    }

    @Override
    public String getCommandName() {
        return "рандом";
    }
}
