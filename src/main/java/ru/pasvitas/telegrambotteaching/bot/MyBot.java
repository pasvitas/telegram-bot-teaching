package ru.pasvitas.telegrambotteaching.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.pasvitas.telegrambotteaching.commands.ByeCommand;
import ru.pasvitas.telegrambotteaching.commands.CommandExcutor;
import ru.pasvitas.telegrambotteaching.commands.HelloCommand;
import ru.pasvitas.telegrambotteaching.commands.RandomNumberCommand;
import ru.pasvitas.telegrambotteaching.commands.SaveCommand;
import ru.pasvitas.telegrambotteaching.commands.WheatherCommand;

public class MyBot extends TelegramLongPollingBot {

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
        //Привет ИмяБота - Привет, ИМЯ
        CommandExcutor sendMessage = new HelloCommand();
        CommandExcutor randomNumberCommand = new RandomNumberCommand();
        CommandExcutor[] botCommands = new CommandExcutor[] {
                sendMessage,
                randomNumberCommand,
                new ByeCommand(),
                new WheatherCommand(),
                new SaveCommand()
        };
        for (int i = 0; i < botCommands.length; i++) {
            if (botCommands[i].getCommandName().equals(update.getMessage().getText())) {
                botCommands[i].executeCommand(update.getMessage().getChat().getId().toString(), update.getMessage(), this);
            }
        }
    }


}
