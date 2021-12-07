package ru.pasvitas.telegrambotteaching.service;

import ru.pasvitas.telegrambotteaching.bot.Bot;
import ru.pasvitas.telegrambotteaching.model.OutputMessageInfo;
import ru.pasvitas.telegrambotteaching.model.SourceType;

public interface SendService {
    void sendMessage(OutputMessageInfo outputMessageInfo, SourceType sourceType);
    void registerOutput(Bot bot);
}
