package ru.pasvitas.telegrambotteaching.service;

import java.util.HashMap;
import java.util.Map;
import ru.pasvitas.telegrambotteaching.bot.Bot;
import ru.pasvitas.telegrambotteaching.model.OutputMessageInfo;
import ru.pasvitas.telegrambotteaching.model.SourceType;

public class SendServiceImpl implements SendService {

    private final Map<SourceType, Bot> sourceTypeBotMap = new HashMap<>();

    @Override
    public void sendMessage(OutputMessageInfo outputMessageInfo, SourceType sourceType) {
        if (sourceTypeBotMap.containsKey(sourceType)) {
            sourceTypeBotMap.get(sourceType).sendMessage(outputMessageInfo);
        }
    }

    @Override
    public void registerOutput(Bot bot) {
        sourceTypeBotMap.put(bot.getSourceType(), bot);
    }
}
