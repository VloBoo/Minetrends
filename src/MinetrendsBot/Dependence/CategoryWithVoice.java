package MinetrendsBot.Dependence;

public class CategoryWithVoice {
    private long categoryId;
    private long topVoiceId;
    private long[] voiceId = {0L};

    public CategoryWithVoice(long vId, long cId) {
        this.topVoiceId = vId;
        this.categoryId = cId;
    }

    public void setTopVoiceId(long Id) {
        this.topVoiceId = Id;
    }

    public long getTopVoiceId() {
        return topVoiceId;
    }

    public void setCategoryId(long id) {
        this.categoryId = id;
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public long[] getVoiceId() {
        return this.voiceId;
    }

    public void addVoiceId(long id) {
        long[] newVoiceId = new long[this.voiceId.length + 1];
        System.arraycopy(this.voiceId, 0, newVoiceId, 0, this.voiceId.length);
        newVoiceId[this.voiceId.length] = id;
        this.voiceId = newVoiceId;
    }
}
