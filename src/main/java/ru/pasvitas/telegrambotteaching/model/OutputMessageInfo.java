package ru.pasvitas.telegrambotteaching.model;

import java.util.Objects;

public class OutputMessageInfo {

    private final String channelId;
    private final String text;

    public OutputMessageInfo(String channelId, String text) {
        this.channelId = channelId;
        this.text = text;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutputMessageInfo that = (OutputMessageInfo) o;
        return Objects.equals(channelId, that.channelId) && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(channelId, text);
    }
}
