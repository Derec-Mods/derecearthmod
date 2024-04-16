package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


@Mod.EventBusSubscriber public class ShearCluckshroomProcedure {
@SubscribeEvent public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
if (event.getHand() != event.getEntity().getUsedItemHand())
return;
execute(event,event.getLevel(),event.getPos().getX(),event.getPos().getY(),event.getPos().getZ(),event.getTarget());
}
public static void execute(
LevelAccessor world,
double x,
double y,
double z,
Entity entity
) {
execute(null,world,x,y,z,entity);
}
private static void execute(
@Nullable Event event,
LevelAccessor world,
double x,
double y,
double z,
Entity entity
) {
if(
entity == null
) return ;
if (entity instanceof CluckshroomEntity) {if (!true) {if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, new BlockPos(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.sweet_berry_bush.pick_berries")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.sweet_berry_bush.pick_berries")),
SoundSource.NEUTRAL, 1, 1, false);
}
}if(!entity.level.isClientSide()) entity.discard();if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.RED_MUSHROOM));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}if (world instanceof Level _level && !_level.isClientSide()) {
ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.RED_MUSHROOM));
entityToSpawn.setPickUpDelay(10);
_level.addFreshEntity(entityToSpawn);
}if (world instanceof ServerLevel _level) {
Entity entityToSpawn = new Chicken(EntityType.CHICKEN, _level);
entityToSpawn.moveTo(x, y, z, 0, 0);
entityToSpawn.setYBodyRot(0);
entityToSpawn.setYHeadRot(0);
entityToSpawn.setDeltaMovement(0, 0, 0);
if (entityToSpawn instanceof Mob _mobToSpawn)
_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
world.addFreshEntity(entityToSpawn);
}
}}
}
}
