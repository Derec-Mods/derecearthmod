package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class DispenseMudProcedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z,
Entity entity
) {
if(
entity == null
) return ;
if ((world.getBlockState(new BlockPos(x,y+1,z))).getBlock() == Blocks.AIR) {if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, new BlockPos(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty")),
SoundSource.NEUTRAL, 1, 1, false);
}
}world.setBlock(new BlockPos(x,y+1,z), MinecraftEarthModModBlocks.MUD.get().defaultBlockState(),3);if (entity instanceof Player _player) {
ItemStack _stktoremove = new ItemStack(MinecraftEarthModModItems.BUCKET_OF_MUD.get());
_player.getInventory()
.clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
}if (entity instanceof Player _player) {
ItemStack _setstack = new ItemStack(MinecraftEarthModModItems.PAIL.get());
_setstack.setCount(1);
ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
}}
}
}
