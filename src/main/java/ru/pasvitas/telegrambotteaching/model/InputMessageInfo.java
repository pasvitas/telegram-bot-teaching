package ru.pasvitas.telegrambotteaching.model;

public class InputMessageInfo {

    private final String channelId;
    private final User user;
    private final String message;

    public InputMessageInfo(String channelId, User user, String message) {
        this.channelId = channelId;
        this.user = user;
        this.message = message;
    }

    public String getChannelId() {
        return channelId;
    }

    public User getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }
}
