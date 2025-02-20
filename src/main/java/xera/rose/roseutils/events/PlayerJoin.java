package xera.rose.roseutils.events;

import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class PlayerJoin extends PlayerListener {
    @Override
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(ChatColor.DARK_RED + event.getPlayer().getName() + " Has joined the hell.");
    }
}
