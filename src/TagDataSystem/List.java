package TagDataSystem;

public class List implements DataTag {
    private String name;
    private Class oClass;
    private String[] value;

    public List(String name) {
        setName(name);
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class getOClass() {
        return this.oClass;
    }

    @Override
    public void setOClass(Class oClass) {
        this.oClass = oClass;
    }

    @Override
    public boolean isPacket() {
        return false;
    }

    @Override
    public boolean isCell() {
        return false;
    }

    @Override
    public boolean isList() {
        return true;
    }

    public String[] getValue() {
        return value;
    }

    public void setValue(String[] value) {
        this.value = value;
    }
}
