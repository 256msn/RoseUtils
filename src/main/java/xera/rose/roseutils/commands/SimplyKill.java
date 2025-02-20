package xera.rose.roseutils.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SimplyKill extends BaseCommand {
    public SimplyKill() {
        super("kill");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You Cant Kill Console");
            return;
        }

        Player player = (Player) sender;
        if (args.length == 0) {
            player.setHealth(0);
            player.sendMessage(ChatColor.RED + "You Killed Yourself!");
            Bukkit.getServer().getLogger().info(player.getName() + " Committed Seppukku!");
        }
    }
}
