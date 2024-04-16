package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class CheckMuddyPigOnFireProcedure {
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
double random = 0;
if (entity.isOnFire()) {random = Math.random()*100;if (entity instanceof MuddyPigEntity) {if (random<=75) {if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.COOKED_PORKCHOP));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}else{if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.COOKED_PORKCHOP));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.COOKED_PORKCHOP));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}}if (entity instanceof CluckshroomEntity) {if (random<=75) {if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.COOKED_CHICKEN));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}else{if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.COOKED_CHICKEN));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.COOKED_CHICKEN));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}}if (entity instanceof MoobloomEntity) {if (random<=75) {if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.COOKED_BEEF));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}else{if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.COOKED_BEEF));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.COOKED_BEEF));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}}if (entity instanceof HornedSheepEntity) {if (random<=75) {if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.COOKED_MUTTON));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}else{if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.COOKED_MUTTON));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.COOKED_MUTTON));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}}}
}
}
