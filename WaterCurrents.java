package me.keyboii.current;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class WaterCurrents extends JavaPlugin {
    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(new CurrentEvents(), this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN+ "[WaterCurrents]: Plugin is enabled!");
    }

    @Override
    public void onDisable(){
        getServer().getConsoleSender().sendMessage(ChatColor.RED+ "[WaterCurrents]: Plugin is disabled!");
    }
}
