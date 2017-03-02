package com.caxerx.mc.adminitem;

import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.nbt.NbtCompound;
import com.comphenix.protocol.wrappers.nbt.NbtFactory;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemBinder {
    private ItemStack craftItem;
    private NbtCompound nbtCompound;

    public ItemBinder(ItemStack item) {
        craftItem = MinecraftReflection.getBukkitItemStack(item.clone());
        nbtCompound = NbtFactory.asCompound(NbtFactory.fromItemTag(craftItem));
    }

    public ItemStack getItem() {
        NbtFactory.setItemTag(craftItem, nbtCompound);
        return craftItem;
    }

    public void bind(Player player) {
        nbtCompound.put("AdminItem", player.getUniqueId().toString());
    }

    public void unbind() {
        if (nbtCompound.containsKey("AdminItem")) {
            nbtCompound.remove("AdminItem");
        }
    }

    public String getItemOwner() {
        if (nbtCompound.containsKey("AdminItem")) {
            return nbtCompound.getString("AdminItem");
        } else {
            return null;
        }
    }
}