package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


@Mod.EventBusSubscriber public class FurnaceGolemTargetProcedure {
@SubscribeEvent public static void onEntitySetsAttackTarget(LivingChangeTargetEvent event) {
execute(event,event.getOriginalTarget(),event.getEntity());
}
public static void execute(
Entity entity,
Entity sourceentity
) {
execute(null,entity,sourceentity);
}
private static void execute(
@Nullable Event event,
Entity entity,
Entity sourceentity
) {
if(
entity == null ||
sourceentity == null
) return ;
if (sourceentity instanceof FurnaceGolemEntity) {entity.getPersistentData().putBoolean("pissed", true);entity.getPersistentData().putDouble("calmtimer", 0);}
}
}
