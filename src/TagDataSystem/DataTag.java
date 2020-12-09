package TagDataSystem;

public interface DataTag {
    void setName(String name);
    String getName();
    Class getOClass();
    void setOClass(Class oClass);
    boolean isPacket();
    boolean isCell();
    boolean isList();
    String[] getValue();
    void setValue(String[] value);
}
