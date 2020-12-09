package TagDataSystem;

public class Cell implements DataTag {
    private String name;
    private Class oClass;
    private String value;

    public Cell(String name) {
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
        return true;
    }

    @Override
    public boolean isList() {
        return false;
    }

    public String[] getValue() {
        return new String[]{value};
    }

    public void setValue(String[] value) {
        if (value.length >= 2) {
            System.err.println("Cell dont have 2 and more value");
            return;
        }
        this.value = value[0];
    }
}
