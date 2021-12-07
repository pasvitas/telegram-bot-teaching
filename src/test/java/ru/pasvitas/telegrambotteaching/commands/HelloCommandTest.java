package ru.pasvitas.telegrambotteaching.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.pasvitas.telegrambotteaching.model.InputMessageInfo;
import ru.pasvitas.telegrambotteaching.model.OutputMessageInfo;
import ru.pasvitas.telegrambotteaching.model.SourceType;
import ru.pasvitas.telegrambotteaching.model.User;
import ru.pasvitas.telegrambotteaching.service.SendService;

import static org.junit.jupiter.api.Assertions.*;

class HelloCommandTest {

    private final SendService sendService = Mockito.mock(SendService.class);
    private final HelloCommand helloCommand = new HelloCommand(sendService);
    private final InputMessageInfo inputMessageInfo = Mockito.mock(InputMessageInfo.class);

    @BeforeEach
    void setUp() {
        Mockito.when(inputMessageInfo.getChannelId()).thenReturn("1");
        User user = new User("Имя");
        Mockito.when(inputMessageInfo.getUser()).thenReturn(user);
    }

    @DisplayName("Execute command with channel id 1")
    @Test
    void executeCommandWithId1() {
        helloCommand.executeCommand(inputMessageInfo, SourceType.TELEGRAM);
        Mockito.verify(sendService, Mockito.times(1)).sendMessage(new OutputMessageInfo(
                "1",
                "Привет, Имя"
        ), SourceType.TELEGRAM);
        Mockito.verify(sendService, Mockito.never()).sendMessage(new OutputMessageInfo(
                "1",
                "Привет, Имя"
        ), SourceType.DISCORD);
    }

    @DisplayName("Execute command with channel id 1")
    @Test
    void executeCommandWithId2() {
        Mockito.when(inputMessageInfo.getChannelId()).thenReturn("2");
        helloCommand.executeCommand(inputMessageInfo, SourceType.TELEGRAM);
        Mockito.verify(sendService, Mockito.times(1)).sendMessage(new OutputMessageInfo(
                "2",
                "Привет, Имя"
        ), SourceType.TELEGRAM);
        Mockito.verify(sendService, Mockito.never()).sendMessage(new OutputMessageInfo(
                "2",
                "Привет, Имя"
        ), SourceType.DISCORD);
    }

    @DisplayName("Execute command with channel id 1 again")
    @Test
    void executeCommandWithId1Again() {
        helloCommand.executeCommand(inputMessageInfo, SourceType.TELEGRAM);
        Mockito.verify(sendService, Mockito.times(1)).sendMessage(new OutputMessageInfo(
                "1",
                "Привет, Имя"
        ), SourceType.TELEGRAM);
        Mockito.verify(sendService, Mockito.never()).sendMessage(new OutputMessageInfo(
                "1",
                "Привет, Имя"
        ), SourceType.DISCORD);
    }
}