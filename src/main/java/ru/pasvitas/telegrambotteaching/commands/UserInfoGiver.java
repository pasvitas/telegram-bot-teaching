package ru.pasvitas.telegrambotteaching.commands;

import org.telegram.telegrambots.meta.api.objects.User;

public interface UserInfoGiver {
    String getUserInfo(User user);
}
