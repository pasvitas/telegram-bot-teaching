package ru.pasvitas.telegrambotteaching.commands;

import org.telegram.telegrambots.meta.api.objects.User;
import ru.pasvitas.telegrambotteaching.model.InputMessageInfo;
import ru.pasvitas.telegrambotteaching.model.SourceType;
import ru.pasvitas.telegrambotteaching.service.SendService;

public class HelloCommand extends BotCommand implements UserInfoGiver {

    public HelloCommand(SendService service) {
        super(service);
    }

    @Override
    public String getCommandName() {
        return "привет";
    }

    @Override
    public void executeCommand(InputMessageInfo inputMessageInfo, SourceType sourceType) {
        sendMessage(inputMessageInfo.getChannelId(),
                "Привет, " + inputMessageInfo.getUser().getName(),
                sourceType);
    }

    @Override
    public String getUserInfo(User user) {
        return user.getFirstName() + " " + user.getLastName();
    }
}
