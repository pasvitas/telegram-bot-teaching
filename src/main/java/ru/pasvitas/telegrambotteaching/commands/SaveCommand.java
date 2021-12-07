package ru.pasvitas.telegrambotteaching.commands;

import org.telegram.telegrambots.meta.api.objects.User;
import ru.pasvitas.telegrambotteaching.model.InputMessageInfo;
import ru.pasvitas.telegrambotteaching.model.SourceType;
import ru.pasvitas.telegrambotteaching.service.CommandService;

public class SaveCommand implements CommandExecutor, UserInfoGiver {

    @Override
    public String getCommandName() {
        return null;
    }

    @Override
    public void executeCommand(InputMessageInfo inputMessageInfo, SourceType sourceType) {

    }

    @Override
    public String getUserInfo(User user) {
        return user.getFirstName() + " " + user.getLastName();
    }
}
