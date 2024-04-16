package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class TropicalSlimeSmallEntityFallsProcedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z
) {
if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, new BlockPos(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.slime.jump")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.slime.jump")),
SoundSource.NEUTRAL, 1, 1, false);
}
}
}
}
