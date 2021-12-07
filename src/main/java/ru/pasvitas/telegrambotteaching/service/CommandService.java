package ru.pasvitas.telegrambotteaching.service;

import ru.pasvitas.telegrambotteaching.model.InputMessageInfo;
import ru.pasvitas.telegrambotteaching.model.SourceType;

public interface CommandService {
    void processMessage(InputMessageInfo inputMessageInfo, SourceType sourceType);
}
