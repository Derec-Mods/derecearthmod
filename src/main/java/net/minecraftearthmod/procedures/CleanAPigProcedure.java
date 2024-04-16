package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class CleanAPigProcedure {
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
if(!entity.level.isClientSide()) entity.discard();if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, new BlockPos(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty_lava")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty_lava")),
SoundSource.NEUTRAL, 1, 1, false);
}
}if (world instanceof ServerLevel _level) {
Entity entityToSpawn = new Pig(EntityType.PIG, _level);
entityToSpawn.moveTo(x, y, z, entity.getYRot(), entity.getXRot());
entityToSpawn.setYBodyRot(entity.getYRot());
entityToSpawn.setYHeadRot(entity.getYRot());
entityToSpawn.setDeltaMovement((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z()));
if (entityToSpawn instanceof Mob _mobToSpawn)
_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
world.addFreshEntity(entityToSpawn);
}
}
}
