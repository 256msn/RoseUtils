package xera.rose.roseutils.commands;

import java.util.ArrayList;
import java.util.Collections;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class GiveCommand extends BaseCommand {
    static {
        ArrayList<String> materialList = new ArrayList<>();
        for (Material material : Material.values()) {
            materialList.add(material.name());
        }
        Collections.sort(materialList);
    }

    public GiveCommand() {
        super("give");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if ((args.length < 2)) {
            sender.sendMessage(ChatColor.RED + "Usage: " + "/give <player> <item> [amount [data]]");
            return;
        }

        Player player = Bukkit.getServer().getPlayer(args[0]);

        if (player != null) {
            Material material = Material.matchMaterial(args[1]);

            if (material == null) {
                material = Material.getMaterial(args[1]);
            }

            if (material != null) {
                int amount = 1;
                short data = 0;

                if (args.length >= 3) {
                    amount = Integer.parseInt(args[2]);

                    if (args.length >= 4) {
                        try {
                            data = Short.parseShort(args[3]);
                        } catch (NumberFormatException ignored) {}
                    }
                }

                ItemStack stack = new ItemStack(material, amount, data);

                player.getInventory().addItem(stack);

                sender.sendMessage("Gave " + player.getName() + " some " + material.getId() + " (" + material + ")");
            } else {
                sender.sendMessage(ChatColor.RED + "There's no item called. " + args[1]);
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Can't find player. " + args[0]);
        }
    }
}