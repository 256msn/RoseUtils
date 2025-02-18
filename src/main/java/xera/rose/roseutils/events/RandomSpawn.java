package xera.rose.roseutils.events;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RandomSpawn extends PlayerListener {
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        World world = player.getWorld();
        Location loc = this.generateRandomLocation(world);
        switch(world.getEnvironment()) {
            default:
                event.setRespawnLocation(loc);
        }
    }

    public boolean checkValidLocation(Location loc) {
        return loc.getBlock().getType() != Material.LAVA && loc.getBlock().getType() != Material.STATIONARY_LAVA && loc.getBlock().getType() != Material.STATIONARY_WATER && loc.getBlock().getType() != Material.WATER && loc.getBlock().getType() != Material.CACTUS;
    }

    public Location generateRandomLocation(World world) {
        Location randomLocation = new Location(world, 0.0D, 0.0D, 0.0D);

        do {
            int x = 550 + (int)(Math.random() * -550.0D);
            int z = 550 + (int)(Math.random() * -550.0D);
            Location location = new Location(world, Double.parseDouble(Integer.toString(x)), 0.0D, Double.parseDouble(Integer.toString(z)));
            Chunk chunk = world.getChunkAt(location);
            if (!world.isChunkLoaded(chunk)) {
                world.loadChunk(chunk);
            }

            int y = world.getHighestBlockYAt(x, z);
            randomLocation.setX(Double.parseDouble(Integer.toString(x)));
            randomLocation.setY(Double.parseDouble(Integer.toString(y)));
            randomLocation.setZ(Double.parseDouble(Integer.toString(z)));
        } while(!this.checkValidLocation(randomLocation));

        return randomLocation;
    }
}

