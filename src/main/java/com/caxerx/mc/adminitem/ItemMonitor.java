package com.caxerx.mc.adminitem;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by caxerx on 2017/3/2.
 */
public class ItemMonitor implements Listener {
    @EventHandler
    public void onPlayerPick(PlayerPickupItemEvent e) {
        ItemStack item = e.getItem().getItemStack();
        ItemBinder ib = new ItemBinder(item);
        if (e.getPlayer().hasPermission("adminitem.exist")) {
            ib.bind(e.getPlayer());
            e.getItem().setItemStack(ib.getItem());
        } else {
            e.setCancelled(true);
            e.getItem().remove();
        }
    }
}
