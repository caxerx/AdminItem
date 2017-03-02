package com.caxerx.mc.adminitem;

import org.bukkit.Bukkit;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by caxerx on 2017/3/2.
 */
public class CheckItemRunnable extends BukkitRunnable {
    public void run() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            if (!player.hasPermission("adminitem.exist")) {
                PlayerInventory inv = player.getInventory();
                new AsyncCheckRunnable(inv).runTaskAsynchronously(AdminItem.getPlugin());
            }
        });
    }
}
