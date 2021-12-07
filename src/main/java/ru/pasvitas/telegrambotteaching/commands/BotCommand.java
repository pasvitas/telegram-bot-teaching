package ru.pasvitas.telegrambotteaching.commands;

import ru.pasvitas.telegrambotteaching.model.OutputMessageInfo;
import ru.pasvitas.telegrambotteaching.model.SourceType;
import ru.pasvitas.telegrambotteaching.service.SendService;

public abstract class BotCommand implements CommandExecutor {

    private final SendService sendMessage;

    protected BotCommand(SendService sendMessage) {
        this.sendMessage = sendMessage;
    }

    protected void sendMessage(String chatId, String message, SourceType sourceType) {
        OutputMessageInfo outputMessageInfo = new OutputMessageInfo(
                chatId, message
        );
        sendMessage.sendMessage(outputMessageInfo, sourceType);
    }
}
