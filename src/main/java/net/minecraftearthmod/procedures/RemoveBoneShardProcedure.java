package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class RemoveBoneShardProcedure {
public static void execute(
Entity entity,
ItemStack itemstack
) {
if(
entity == null
) return ;
if(entity instanceof Player _player)
_player.getCooldowns().addCooldown(itemstack.getItem(), 20);if (entity instanceof Player _player) {
ItemStack _stktoremove = new ItemStack(MinecraftEarthModModItems.BONESHARD.get());
_player.getInventory()
.clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
}
}
}
