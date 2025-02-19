package xera.rose.roseutils.events;

import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerListener;

public class GreenText extends PlayerListener {
    public void onPlayerChat(PlayerChatEvent event) {
        if (event.getMessage().startsWith(">"))
            event.setMessage(ChatColor.GREEN + event.getMessage());
    }
}
