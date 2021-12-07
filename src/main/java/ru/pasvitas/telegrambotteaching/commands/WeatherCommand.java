package ru.pasvitas.telegrambotteaching.commands;

import ru.pasvitas.telegrambotteaching.model.InputMessageInfo;
import ru.pasvitas.telegrambotteaching.model.SourceType;
import ru.pasvitas.telegrambotteaching.service.SendService;

public class WeatherCommand extends BotCommand {

    public WeatherCommand(SendService service) {
        super(service);
    }

    @Override
    public String getCommandName() {
        return "погода";
    }

    @Override
    public void executeCommand(InputMessageInfo inputMessageInfo, SourceType sourceType) {

    }
}
