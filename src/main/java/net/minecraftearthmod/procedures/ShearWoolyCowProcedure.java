package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class ShearWoolyCowProcedure {
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
if (entity instanceof HornedSheepEntity) {if (entity.getPersistentData().getDouble("regrow")>=6000) {if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY).getItem() == Items.SHEARS) {if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild:false)) {{
ItemStack _ist = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY);
if(_ist.hurt(1, RandomSource.create(), null)) {
_ist.shrink(1);
_ist.setDamageValue(0);
}
}}entity.getPersistentData().putDouble("regrow", 0);if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, new BlockPos(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")),
SoundSource.NEUTRAL, 1, 1, false);
}
}if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.WHITE_WOOL));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}if (Math.random()*100<=50) {if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.WHITE_WOOL));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}if (Math.random()*100<=50) {if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.WHITE_WOOL));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}}}else{if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, new BlockPos(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.ambient")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.ambient")),
SoundSource.NEUTRAL, 1, 1, false);
}
}}}if (entity instanceof RainbowSheepEntity) {if (entity.getPersistentData().getDouble("regrow")>=6000) {if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY).getItem() == Items.SHEARS) {if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild:false)) {{
ItemStack _ist = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY);
if(_ist.hurt(1, RandomSource.create(), null)) {
_ist.shrink(1);
_ist.setDamageValue(0);
}
}}entity.getPersistentData().putDouble("regrow", 0);if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, new BlockPos(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")),
SoundSource.NEUTRAL, 1, 1, false);
}
}if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MinecraftEarthModModBlocks.RAINBOW_WOOL.get()));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}if (Math.random()*100<=50) {if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MinecraftEarthModModBlocks.RAINBOW_WOOL.get()));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}if (Math.random()*100<=50) {if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(MinecraftEarthModModBlocks.RAINBOW_WOOL.get()));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}}}else{if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, new BlockPos(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.ambient")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.ambient")),
SoundSource.NEUTRAL, 1, 1, false);
}
}}}if (entity instanceof RainbowSheepEntity) {if (entity.getPersistentData().getDouble("regrow")>=6000) {if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY).getItem() == Items.SHEARS) {if (!(sourceentity instanceof Player _plr ? _plr.getAbilities().instabuild:false)) {{
ItemStack _ist = (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY);
if(_ist.hurt(1, RandomSource.create(), null)) {
_ist.shrink(1);
_ist.setDamageValue(0);
}
}}entity.getPersistentData().putDouble("regrow", 0);if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, new BlockPos(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")),
SoundSource.NEUTRAL, 1, 1, false);
}
}if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.GRAY_WOOL));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}if (Math.random()*100<=50) {if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.GRAY_WOOL));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}if (Math.random()*100<=50) {if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.GRAY_WOOL));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}}}}else{if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, new BlockPos(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.ambient")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.ambient")),
SoundSource.NEUTRAL, 1, 1, false);
}
}}}
}
}
