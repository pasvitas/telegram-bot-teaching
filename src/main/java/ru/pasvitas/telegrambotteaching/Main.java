package ru.pasvitas.telegrambotteaching;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.pasvitas.telegrambotteaching.bot.TelegramBot;
import ru.pasvitas.telegrambotteaching.service.CommandService;
import ru.pasvitas.telegrambotteaching.service.CommandServiceImpl;
import ru.pasvitas.telegrambotteaching.service.SendService;
import ru.pasvitas.telegrambotteaching.service.SendServiceImpl;

public class Main {

    public static void main(String[] args) {
        try {
            SendService sendService = new SendServiceImpl();
            CommandService commandService = new CommandServiceImpl(sendService);
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new TelegramBot(commandService, sendService));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
