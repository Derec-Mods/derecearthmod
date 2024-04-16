package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


@Mod.EventBusSubscriber public class CheckSleepDimensionProcedure {
@SubscribeEvent public static void onPlayerInBed(PlayerSleepInBedEvent event) {
execute(event,event.getEntity().level,event.getEntity());
}
public static void execute(
LevelAccessor world,
Entity entity
) {
execute(null,world,entity);
}
private static void execute(
@Nullable Event event,
LevelAccessor world,
Entity entity
) {
if(
entity == null
) return ;
if (entity.level.dimension()==ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("minecraft_earth_mod:minecraft_earth_dimension"))) {if (!(world instanceof Level _lvl2 && _lvl2.isDay())) {if (world instanceof ServerLevel _level) _level.setDayTime(1);}}
}
}
