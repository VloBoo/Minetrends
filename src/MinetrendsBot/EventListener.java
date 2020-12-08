package MinetrendsBot;

import MinetrendsBot.Dependence.CategoryWithVoice;
import MinetrendsBot.Dependence.MessageWithEmoji;
import MinetrendsBot.Dependence.MessageWithRole;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceUpdateEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GenericGuildMessageReactionEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

public class EventListener extends ListenerAdapter {

    //Все данные, которые должны приходить из вне класс, пока не реализованно, так как нету норм БД.
    private final MessageWithEmoji[] messageWithEmoji = new MessageWithEmoji[]{new MessageWithEmoji(725718213693931610L, new String[]{"U+1F44D", "U+1F44E"}), new MessageWithEmoji(725718244513677382L, new String[]{"U+31U+fe0fU+20E3", "U+32U+fe0fU+20E3"})};
    private final MessageWithRole[] messageWithRole = new MessageWithRole[]{new MessageWithRole(783705477715853402L, new String[]{"U+32U+fe0fU+20e3", "U+31U+fe0fU+20e3"}, new long[]{783703792222732289L, 783703740468166657L}), new MessageWithRole(783955876662738964L, new String[]{"U+32U+fe0fU+20e3", "U+31U+fe0fU+20e3"}, new long[]{783956725719367681L, 783956725719367681L})};
    private CategoryWithVoice[] categoryWithVoices = new CategoryWithVoice[]{new CategoryWithVoice(784002056222146570L, 0L)};
    private long logChannel = 756851443033571369L;
    ArrayList<String> bufferName;
    //=============================================================================================

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return;
        }
        for (MessageWithEmoji withEmoji : messageWithEmoji) {
            if (event.getChannel().getIdLong() == withEmoji.getChannelId()) {
                for (int k = 0; k < withEmoji.getEmoji().length; k++) {
                    event.getMessage().addReaction(withEmoji.getEmoji()[k]).complete();
                }
                return;
            }
        }
    }

    public void onGuildMessageReactionAdd(@NotNull GuildMessageReactionAddEvent event) {
        roleOfReaction(event, true);
    }

    public void onGuildMessageReactionRemove(@NotNull GuildMessageReactionRemoveEvent event) {
        roleOfReaction(event, false);
    }

    private void roleOfReaction(GenericGuildMessageReactionEvent event, boolean giveOrTake) {
        for (MessageWithRole withRole : messageWithRole) {
            if (event.getMessageIdLong() == withRole.getMessageId()) {
                for (int k = 0; k < withRole.getEmoji().length; k++) {
                    if (withRole.getEmoji()[k].equals(event.getReactionEmote().getAsCodepoints())) {
                        String user = event.getUserId();
                        Role role = Objects.requireNonNull(event.getGuild().getRoleById(withRole.getRole()[k]));
                        if (giveOrTake) {
                            event.getGuild().addRoleToMember(user, role).queue();
                        } else {
                            event.getGuild().removeRoleFromMember(user, role).queue();
                        }
                    }
                }
                return;
            }
        }
    }

    public void onGuildVoiceUpdate(GuildVoiceUpdateEvent event) {
        if (event.getChannelJoined() != null) {
            for (int i = 0; i < categoryWithVoices.length; i++) {
                if (event.getChannelJoined().getIdLong() == categoryWithVoices[i].getTopVoiceId()) {
                    if (event.getChannelJoined().getParent()==null){System.err.println(301);return;}
                    if (event.getChannelJoined().getParent().getIdLong() == categoryWithVoices[i].getCategoryId() ) {
                        String name=event.getEntity().getEffectiveName();
                        event.getChannelJoined().getParent().createVoiceChannel(name).queue();
                        bufferName.add(name);
                    } else {
                        System.err.print(302);
                    }
                    return;
                }
            }
        }
    }

}
