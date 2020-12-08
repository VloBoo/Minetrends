package MinetrendsBot.Dependence;

public class MessageWithRole {
    private long messageId = 34L;
    private String emoji[] = {"34", "23"};
    private long role[] = {12L, 32L};

    public MessageWithRole(long id ,String[] emoji, long[] role){
        this.messageId=id;
        setERole(emoji,role);
    }

    public long getMessageId() {
        return this.messageId;
    }

    public String[] getEmoji() {
        return this.emoji;
    }

    public long[] getRole() {
        return this.role;
    }

    public void setERole(String[] emoji, long[] role) {
        this.emoji = emoji;
        this.role = role;
    }
}
