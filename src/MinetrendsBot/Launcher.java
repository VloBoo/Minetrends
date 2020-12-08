package MinetrendsBot;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Launcher {

    private static String tokenBot = "NzgzNTg1ODA5ODUyMzk5NjY2.X8c5Jw.e3a1US5HG7imG0tmTXb1BQhSqGo";
    public static JDA jda;

    public static void main(String[] args) throws LoginException {
        jda= JDABuilder.createDefault(tokenBot).build();
        jda.getPresence().setActivity(Activity.watching("By VloBo"));
        jda.addEventListener(new EventListener());

    }
}
