package xera.rose.roseutils.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xera.rose.roseutils.Main;

public abstract class BaseCommand implements CommandExecutor {

    protected final String name;

    BaseCommand(String name) {
        this.name = name;
        Main.instance.getCommand(name).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            String permission = cmd.getPermission();
            if (permission != null){
                if (player.hasPermission(permission)){
                    execute(sender, args);
                }else {
                    player.sendMessage(ChatColor.RED + "You don't have permission to execute this command.");
                    return false;
                }
            }else {
                execute(sender, args);
            }
        }else {
            execute(sender, args);
        }
        return true;
    }

    public abstract void execute(CommandSender sender, String[] args);

}
