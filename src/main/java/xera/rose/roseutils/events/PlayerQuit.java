package xera.rose.roseutils.events;

import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit extends PlayerListener {
    @Override
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage(ChatColor.DARK_AQUA + event.getPlayer().getName() + " Escaped and has now reached heaven.");
    }
}
