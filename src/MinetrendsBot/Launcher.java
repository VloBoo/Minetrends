package MinetrendsBot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Launcher {

    private final static String path = "./src/tokenBot.txt";
    public static JDA jda;

    public static void main(String[] args) throws LoginException, IOException {
        FileReader fileReader = new FileReader(new File(path));
        char[] buf = new char[256];
        int c;
        while ((c = fileReader.read(buf)) != -1) {
            if (c < 256) {
                buf = Arrays.copyOf(buf, c);
            }
        }
        String token = new String(buf);
        if (token != null) {
            jda = JDABuilder.createDefault(token).build();
            jda.getPresence().setActivity(Activity.watching("By VloBo"));
            jda.addEventListener(new EventListener());
        }

    }
}
