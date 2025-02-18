package xera.rose.roseutils;

import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;
import xera.rose.roseutils.commands.GiveCommand;
import xera.rose.roseutils.events.BlockPlace;
import xera.rose.roseutils.events.PlayerJoin;
import xera.rose.roseutils.events.PlayerQuit;
import xera.rose.roseutils.events.RandomSpawn;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        PlayerJoin playerJoin = new PlayerJoin();
        PlayerQuit playerQuit = new PlayerQuit();
       getCommand("give").setExecutor(new GiveCommand());
       getServer().getPluginManager().registerEvent(Event.Type.PLAYER_JOIN, playerJoin, Event.Priority.Normal, this);
       getServer().getPluginManager().registerEvent(Event.Type.PLAYER_QUIT, playerQuit, Event.Priority.Normal, this);
       getServer().getPluginManager().registerEvent(Event.Type.BLOCK_PLACE, new BlockPlace(), Event.Priority.Normal, this);
        getServer().getPluginManager().registerEvent(Event.Type.PLAYER_RESPAWN, new RandomSpawn(), Event.Priority.Highest, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
