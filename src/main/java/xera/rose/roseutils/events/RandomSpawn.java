package xera.rose.roseutils.events;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class RandomSpawn extends PlayerListener {
    @Override
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        World world = player.getWorld();
        Location loc = this.generateRandomLocation(world);
        switch(world.getEnvironment())
        {
            case NETHER:
                loc.setWorld(Bukkit.getWorlds().get(0));
                event.setRespawnLocation(loc);
            default:
                event.setRespawnLocation(loc);
        }
    }

    public boolean checkValidLocation(Location loc) {
        return loc.getBlock().getType() != Material.LAVA && loc.getBlock().getType()
                != Material.STATIONARY_LAVA && loc.getBlock().getType()
                != Material.STATIONARY_WATER && loc.getBlock().getType()
                != Material.WATER && loc.getBlock().getType() != Material.CACTUS;
    }

    public Location generateRandomLocation(World world) {
        Location randomLocation = new Location(world, 0.0, 0.0D, 0.0D);

        do {
            int x = 1000 + (int) (Math.random() * -2000);
            int z = 1000 + (int) (Math.random() * -2000);
            Location location = new Location(world, Double.parseDouble(Integer.toString(x)), 0.0D, Double.parseDouble(Integer.toString(z)));
            Chunk chunk = world.getChunkAt(location);
            if (!world.isChunkLoaded(chunk)) {
                world.loadChunk(chunk);
            }

            int y = world.getHighestBlockYAt(x, z);
            randomLocation.setX(Double.parseDouble(Integer.toString(x)));
            randomLocation.setY(Double.parseDouble(Integer.toString(y)));
            randomLocation.setZ(Double.parseDouble(Integer.toString(z)));
        } while (!checkValidLocation(randomLocation));

        return randomLocation;
    }
}
