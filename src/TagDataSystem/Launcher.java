package TagDataSystem;

public class Launcher {

    public static void main(String[] args) {
        Packet packet = new Packet("Test Packet");
        Cell cell = new Cell("Test");
        Cell cell1 = new Cell("Bot");
        Cell cell2 = new Cell("TOt");
        packet.addTag(cell);
        packet.addTag(cell1);
        packet.addTag(cell2);
        packet.deleteTagByName("Byot");
        System.out.println(1);
    }
}
