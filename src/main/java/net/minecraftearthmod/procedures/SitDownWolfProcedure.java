package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class SitDownWolfProcedure {
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
if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame():false) {if ((entity.getPersistentData().getString("sit")).equals("standing")) {entity.getPersistentData().putString("sit", "sitting");if(entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,696,100, false, false));entity.setShiftKeyDown(true);if (world instanceof ServerLevel _level)
_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, x, y, z, 3, 1, 1, 1, 0);if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, new BlockPos(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.whine")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.whine")),
SoundSource.NEUTRAL, 1, 1, false);
}
}}else if ((entity.getPersistentData().getString("sit")).equals("sitting")) {entity.getPersistentData().putString("sit", "standing");entity.setShiftKeyDown(false);if (world instanceof ServerLevel _level)
_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 3, 1, 1, 1, 0);if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, new BlockPos(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.ambient")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.ambient")),
SoundSource.NEUTRAL, 1, 1, false);
}
}}}
}
}
