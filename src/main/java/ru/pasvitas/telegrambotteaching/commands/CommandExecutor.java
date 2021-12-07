package ru.pasvitas.telegrambotteaching.commands;

import ru.pasvitas.telegrambotteaching.model.InputMessageInfo;
import ru.pasvitas.telegrambotteaching.model.SourceType;

public interface CommandExecutor {
    String getCommandName();
    void executeCommand(InputMessageInfo inputMessageInfo, SourceType sourceType);
}
