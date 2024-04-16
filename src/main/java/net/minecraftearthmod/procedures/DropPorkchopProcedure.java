package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class DropPorkchopProcedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z,
Entity entity,
Entity sourceentity
) {
if(
entity == null ||
sourceentity == null
) return ;
double rand = 0;
rand = Math.random();if (entity.isOnFire()) {if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.COOKED_PORKCHOP));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}if (rand<0.33) {if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.COOKED_PORKCHOP));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}if (rand>=0&&rand<=0.16&&EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MOB_LOOTING, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY))>=1) {if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.COOKED_PORKCHOP));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}}if (rand>=0.33&&rand<=0.66) {if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.COOKED_PORKCHOP));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}if (rand>=0.33&&rand<=0.49&&EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MOB_LOOTING, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY))>=1) {if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.COOKED_PORKCHOP));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}}}else{if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.PORKCHOP));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}if (rand<0.33) {if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.PORKCHOP));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}if (rand>=0&&rand<=0.16&&EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MOB_LOOTING, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY))>=1) {if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.PORKCHOP));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}}if (rand>=0.33&&rand<=0.66) {if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.PORKCHOP));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}if (rand>=0.33&&rand<=0.49&&EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MOB_LOOTING, (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY))>=1) {if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.PORKCHOP));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}}}
}
}
