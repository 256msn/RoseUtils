package xera.rose.roseutils.events;

import org.bukkit.Material;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class BlockPlace extends BlockListener {
    @Override
    public void onBlockPlace(BlockPlaceEvent event) {
        if (isChecked(event.getBlock().getType())) {
            event.setCancelled(true);
            event.getPlayer().sendRawMessage("&e[SERVER] That block is not allowed.".replace("&", "§"));
            PlayerInventory inventory = event.getPlayer().getInventory();
            for (ItemStack itemStack : inventory.getContents()) {
                if (itemStack != null) {
                    if (isChecked(itemStack.getType())) {
                        inventory.remove(itemStack);
                    }
                }
            }
        }
    }
    private boolean isChecked(Material material) {
        switch (material) {
            case BEDROCK:
                return true;
        }
        return false;
    }
}
