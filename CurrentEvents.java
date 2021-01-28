package me.keyboii.current;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Directional;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class CurrentEvents implements Listener {

    @EventHandler
    public static void isAboveCurrent(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        int x = player.getLocation().getBlockX();
        int y = player.getLocation().getBlockY();
        int z = player.getLocation().getBlockZ();


        for (int i = 0; i < y; i++) {
            Material customBlock = player.getWorld().getBlockAt(x, i, z).getType();
            Material playerBlock = player.getWorld().getBlockAt(x, y, z).getType();
            if (customBlock == Material.MAGENTA_GLAZED_TERRACOTTA) {
                Block block = player.getWorld().getBlockAt(x, i, z);
                if (block.getBlockData() instanceof Directional) {
                    Directional arrow = (Directional) block.getBlockData();

                    if (playerBlock == Material.WATER) {
                        if(arrow.getFacing().getOppositeFace() == BlockFace.SOUTH){
                            player.setVelocity(new Vector(0,0,.25));
                        }
                        if(arrow.getFacing().getOppositeFace() == BlockFace.NORTH){
                            player.setVelocity(new Vector(0,0,-.25));
                        }
                        if(arrow.getFacing().getOppositeFace() == BlockFace.EAST){
                            player.setVelocity(new Vector(.25,0,0));
                        }
                        if(arrow.getFacing().getOppositeFace() == BlockFace.WEST){
                            player.setVelocity(new Vector(-.25,0,0));
                        }
                    }
                }
            }
        }
    }
}