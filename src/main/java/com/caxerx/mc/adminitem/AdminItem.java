package com.caxerx.mc.adminitem;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by caxerx on 2017/3/2.
 */
public class AdminItem extends JavaPlugin {
    private static Plugin plugin;

    public void onEnable() {
        plugin = this;
        getServer().getPluginCommand("append").setExecutor(new AppendCommand());
        getServer().getPluginCommand("unbind").setExecutor(new UnbindCommand());
        getServer().getPluginManager().registerEvents(new ItemMonitor(), this);
        new CheckItemRunnable().runTaskTimer(this, 60, 60);
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    public void onDisable() {
        plugin = null;
    }
}
