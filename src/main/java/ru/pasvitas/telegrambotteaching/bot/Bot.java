package ru.pasvitas.telegrambotteaching.bot;

import ru.pasvitas.telegrambotteaching.model.OutputMessageInfo;
import ru.pasvitas.telegrambotteaching.model.SourceType;

public interface Bot {
    void sendMessage(OutputMessageInfo messageInfo);
    SourceType getSourceType();
}
