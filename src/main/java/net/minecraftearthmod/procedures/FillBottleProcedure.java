package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class FillBottleProcedure {
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
if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY).getItem() == Items.GLASS_BOTTLE) {if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, new BlockPos(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bottle.fill")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bottle.fill")),
SoundSource.NEUTRAL, 1, 1, false);
}
}if (entity instanceof Player _player) {
ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE);
_player.getInventory()
.clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
}if (entity instanceof Player _player) {
ItemStack _setstack = new ItemStack(MinecraftEarthModModItems.BUTTERBEER.get());
_setstack.setCount(1);
ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
}}if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY).getItem() == Items.BONE_MEAL) {if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, new BlockPos(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")),
SoundSource.NEUTRAL, 1, 1, false);
}
}if (entity instanceof Player _player) {
ItemStack _stktoremove = new ItemStack(Items.BONE_MEAL);
_player.getInventory()
.clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
}if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MinecraftEarthModModBlocks.BUTTERCUP.get()));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}
}
}
