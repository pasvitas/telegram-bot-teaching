package ru.pasvitas.telegrambotteaching.commands;

import ru.pasvitas.telegrambotteaching.model.InputMessageInfo;
import ru.pasvitas.telegrambotteaching.model.SourceType;
import ru.pasvitas.telegrambotteaching.service.SendService;

public class ByeCommand extends BotCommand {

    public ByeCommand(SendService service) {
        super(service);
    }

    @Override
    public String getCommandName() {
        return "пока";
    }

    @Override
    public void executeCommand(InputMessageInfo inputMessageInfo, SourceType sourceType) {
        sendMessage(inputMessageInfo.getChannelId(),
                "Пока, " + inputMessageInfo.getUser().getName(),
                sourceType);
    }
}
