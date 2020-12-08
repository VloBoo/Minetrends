package MinetrendsBot.Dependence;

public class MessageWithEmoji {
    private long channelId;
    private String emoji[];

    public MessageWithEmoji(long channelId, String[] emoji) {
        setChannelId(channelId);
        setEmoji(emoji);
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String[] getEmoji() {
        return this.emoji;
    }

    public void setChannelId(long id) {
        this.channelId = id;
    }

    public void setEmoji(String[] emoji) {
        this.emoji = emoji;
    }
}
