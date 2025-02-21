package xera.rose.roseutils;

import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;
import xera.rose.roseutils.commands.GiveCommand;
import xera.rose.roseutils.events.BlockPlace;
import xera.rose.roseutils.events.PlayerJoin;
import xera.rose.roseutils.events.PlayerQuit;
import xera.rose.roseutils.events.RandomSpawn;

import javax.activation.CommandMap;

public final class Main extends JavaPlugin {

    public static Main instance;

    @Override
    public void onLoad(){
        instance = this;
    }

    @Override
    public void onEnable() {
        System.out.println("[RoseUtils] Enabled.");
        PlayerJoin playerJoin = new PlayerJoin();
        PlayerQuit playerQuit = new PlayerQuit();
        getCommand("give").setExecutor(new GiveCommand());
        getServer().getPluginManager().registerEvent(Event.Type.PLAYER_JOIN, playerJoin, Event.Priority.Normal, this);
        getServer().getPluginManager().registerEvent(Event.Type.PLAYER_QUIT, playerQuit, Event.Priority.Normal, this);
        getServer().getPluginManager().registerEvent(Event.Type.BLOCK_PLACE, new BlockPlace(), Event.Priority.Normal, this);
        getServer().getPluginManager().registerEvent(Event.Type.PLAYER_RESPAWN, new RandomSpawn(), Event.Priority.Highest, this);
        getServer().getPluginManager().registerEvent(Event.Type.PLAYER_BED_LEAVE, new RandomSpawn(), Event.Priority.Highest, this);
    }

    @Override
    public void onDisable() {
        System.out.println("[RoseUtils] Disabled.");
        // Plugin shutdown logic
    }
}