package TagDataSystem.Data.Structure;

public class Cell {
    private String name;
    private Class typeClass;
    private String[] value;
    private boolean list;
    private boolean packet;

    public void creatCell(String nameCell, Class typeClassCell, String valueCell) {
        creat(nameCell, typeClassCell, new String[]{valueCell}, false, false);
    }

    public void creatList(String nameCell, Class typeClassCell, String[] valueCell) {
        creat(nameCell, typeClassCell, valueCell, true, false);
    }

    public void creatPacket(String nameCell, String[] valueCell) {
        creat(nameCell, null, valueCell, false, true);
    }

    public void creat(String nameCell, Class typeClassCell, String[] valueCell, boolean listCell, boolean packetCell) {
        this.name = nameCell;
        this.typeClass = typeClassCell;
        this.value = valueCell;
        this.list = listCell;
        this.packet = packetCell;
    }
}
