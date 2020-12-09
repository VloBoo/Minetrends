package TagDataSystem;

public class Packet implements DataTag {
    private String name;
    private DataTag[] content;

    public Packet(String name) {
        setName(name);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Class getOClass() {
        System.err.println("Packet dont have content Class");
        return null;
    }

    @Override
    public void setOClass(Class oClass) {
        System.err.println("Packet dont have content Class");
    }

    @Override
    public boolean isPacket() {
        return true;
    }

    @Override
    public boolean isCell() {
        return false;
    }

    @Override
    public boolean isList() {
        return false;
    }

    public void addTag(DataTag tag) {
        if (this.content == null) {
            this.content = new DataTag[]{tag};
            return;
        }

        DataTag[] newContent = new DataTag[content.length + 1];
        for (int i = 0; i < this.content.length; i++) {
            newContent[i] = this.content[i];
        }

        newContent[content.length] = tag;
        this.content = newContent;
    }

    public DataTag getTagByName(String name) {
        if (this.content == null) {
            return null;
        }
        for (int i = 0; i < this.content.length; i++) {
            if (this.content[i].getName().equals(name)) {
                return this.content[i];
            }
        }
        System.err.println("Dont find tag with name '" + name + "'");
        return null;
    }

    public void deleteTagByName(String name) {
        DataTag tag = getTagByName(name);
        if (tag == null) {
            return;
        }
        DataTag[] newContent = new DataTag[content.length - 1];
        int k = 0;
        for (int i = 0; i < this.content.length; i++) {
            if (!(name.equals(this.content[i].getName()))) {
                newContent[k] = this.content[i];
                k++;
            }
        }
        this.content = newContent;
    }

    public String[] getValue() {
        System.err.println("Packet dont have value");
        return null;
    }

    public void setValue(String[] value) {
        System.err.println("Packet dont have value");
    }
}
