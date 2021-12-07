package ru.pasvitas.telegrambotteaching.bot;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.pasvitas.telegrambotteaching.model.InputMessageInfo;
import ru.pasvitas.telegrambotteaching.model.OutputMessageInfo;
import ru.pasvitas.telegrambotteaching.model.SourceType;
import ru.pasvitas.telegrambotteaching.model.User;
import ru.pasvitas.telegrambotteaching.service.CommandService;
import ru.pasvitas.telegrambotteaching.service.SendService;

public class TelegramBot extends TelegramLongPollingBot implements Bot {

    private final CommandService commandService;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public TelegramBot(CommandService commandService, SendService sendService) {
        super();
        this.commandService = commandService;
        sendService.registerOutput(this);
    }

    @Override
    public String getBotUsername() {
        return "bot_name";
    }

    @Override
    public String getBotToken() {
        return "token";
    }

    @Override
    public void onUpdateReceived(Update update) {
        InputMessageInfo inputMessageInfo = new InputMessageInfo(
                update.getMessage().getChatId().toString(),
                new User(
                        update.getMessage().getFrom().getFirstName()
                ),
                update.getMessage().getText()
        );
        executorService.execute(() -> commandService.processMessage(inputMessageInfo, getSourceType()));
    }

    @Override
    public void sendMessage(OutputMessageInfo outputMessageInfo) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(outputMessageInfo.getChannelId());
        sendMessage.setText(outputMessageInfo.getText());
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public SourceType getSourceType() {
        return SourceType.TELEGRAM;
    }
}
