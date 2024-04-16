package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


@Mod.EventBusSubscriber public class FurnaceGolemIgniteProcedure {
@SubscribeEvent public static void onEntityAttacked(LivingAttackEvent event) {
if (event!=null && event.getEntity()!=null) {
execute(event,event.getEntity(),event.getSource().getEntity());
}
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
if (entity instanceof Monster&&sourceentity instanceof FurnaceGolemEntity) {entity.setSecondsOnFire(2);}
}
}
