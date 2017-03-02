package com.caxerx.mc.adminitem;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by caxerx on 2017/3/2.
 */
public class AsyncCheckRunnable extends BukkitRunnable {
    PlayerInventory playerInventory;

    public AsyncCheckRunnable(PlayerInventory inv) {
        playerInventory = inv;
    }

    public void run() {
        ItemStack[] contents = playerInventory.getContents();
        for (int i = 0; i < contents.length; i++) {
            if (contents[i] != null && contents[i].getType() != Material.AIR) {
                ItemBinder ib = new ItemBinder(contents[i]);
                if (ib.getItemOwner() != null) {
                    playerInventory.remove(contents[i]);
                }
            }
        }
    }
}
