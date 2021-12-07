package ru.pasvitas.telegrambotteaching.service;

import ru.pasvitas.telegrambotteaching.commands.ByeCommand;
import ru.pasvitas.telegrambotteaching.commands.CommandExecutor;
import ru.pasvitas.telegrambotteaching.commands.HelloCommand;
import ru.pasvitas.telegrambotteaching.commands.RandomNumberCommand;
import ru.pasvitas.telegrambotteaching.commands.SaveCommand;
import ru.pasvitas.telegrambotteaching.commands.WeatherCommand;
import ru.pasvitas.telegrambotteaching.model.InputMessageInfo;
import ru.pasvitas.telegrambotteaching.model.SourceType;

public class CommandServiceImpl implements CommandService {

    private final SendService sendService;

    public CommandServiceImpl(SendService sendService) {
        this.sendService = sendService;
    }

    @Override
    public void processMessage(InputMessageInfo inputMessageInfo, SourceType sourceType) {
        CommandExecutor sendMessage = new HelloCommand(sendService);
        CommandExecutor commandExecutor = new RandomNumberCommand(sendService);
        RandomNumberCommand randomNumberCommand = new RandomNumberCommand(sendService);
        CommandExecutor[] botCommands = new CommandExecutor[] {
                sendMessage,
                randomNumberCommand,
                commandExecutor,
                new ByeCommand(sendService),
                new WeatherCommand(sendService),
                new SaveCommand()
        };
        for (int i = 0; i < botCommands.length; i++) {
            if (botCommands[i].getCommandName().equals(inputMessageInfo.getMessage())) {
                botCommands[i].executeCommand(inputMessageInfo, sourceType);
            }
        }
    }
}
