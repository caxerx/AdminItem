package com.caxerx.mc.adminitem;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by caxerx on 2017/3/2.
 */
public class UnbindCommand implements CommandExecutor {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender.hasPermission("adminitem.unbind")) {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage(ChatColor.RED + "This command only can use by a in-game player.");
                return true;
            }
            Player player = (Player) commandSender;
            ItemStack mainHandItem = player.getInventory().getItemInMainHand();
            if (mainHandItem != null && mainHandItem.getType() != Material.AIR) {
                ItemBinder ib = new ItemBinder(mainHandItem);
                ib.unbind();
                player.getInventory().setItemInMainHand(ib.getItem());
                commandSender.sendMessage(ChatColor.GREEN + "This item is not longer an " + ChatColor.GOLD + "AdminItem");
            } else {
                commandSender.sendMessage(ChatColor.RED + "This command only can use when holding an item.");
            }
            return true;
        } else {
            commandSender.sendMessage(ChatColor.RED + "You cannot use this command.");
            return true;
        }
    }
}
