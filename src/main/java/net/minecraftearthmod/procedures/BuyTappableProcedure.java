package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class BuyTappableProcedure {
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
double ran = 0;
if (entity instanceof Player _playerHasItem? _playerHasItem.getInventory().contains(new ItemStack(MinecraftEarthModModItems.RUBY.get())):false) {ran = Math.random()*100;MinecraftEarthModModVariables.MapVariables.get(world).paidyet = "yes";
MinecraftEarthModModVariables.MapVariables.get(world).syncData(world);if (ran<=17) {if (entity instanceof Player _player) {
ItemStack _stktoremove = new ItemStack(MinecraftEarthModModItems.RUBY.get());
_player.getInventory()
.clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
}if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MinecraftEarthModModBlocks.CHEST_TAPPABLE.get()));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}if (ran>17&&ran<=34) {if (entity instanceof Player _player) {
ItemStack _stktoremove = new ItemStack(MinecraftEarthModModItems.RUBY.get());
_player.getInventory()
.clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
}if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MinecraftEarthModModBlocks.GRASS_TAPPABLE.get()));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}if (ran>34&&ran<=51) {if (entity instanceof Player _player) {
ItemStack _stktoremove = new ItemStack(MinecraftEarthModModItems.RUBY.get());
_player.getInventory()
.clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
}if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MinecraftEarthModModBlocks.STONE_TAPPABLE.get()));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}if (ran>51&&ran<=68) {if (entity instanceof Player _player) {
ItemStack _stktoremove = new ItemStack(MinecraftEarthModModItems.RUBY.get());
_player.getInventory()
.clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
}if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MinecraftEarthModModBlocks.BIRCH_TAPPABLE.get()));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}if (ran>68&&ran<=85) {if (entity instanceof Player _player) {
ItemStack _stktoremove = new ItemStack(MinecraftEarthModModItems.RUBY.get());
_player.getInventory()
.clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
}if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MinecraftEarthModModBlocks.OAK_TAPPABLE.get()));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}if (ran>85&&ran<=100) {if (entity instanceof Player _player) {
ItemStack _stktoremove = new ItemStack(MinecraftEarthModModItems.RUBY.get());
_player.getInventory()
.clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
}if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MinecraftEarthModModBlocks.SPRUCE_TAPPABLE.get()));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}}else{if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, new BlockPos(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chest.locked")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chest.locked")),
SoundSource.NEUTRAL, 1, 1, false);
}
}}
}
}
