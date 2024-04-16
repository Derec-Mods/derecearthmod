package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


@Mod.EventBusSubscriber public class ConvertToMuddyBucketProcedure {
@SubscribeEvent public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
if (event.getHand() != event.getEntity().getUsedItemHand())
return;
execute(event,event.getLevel(),event.getPos().getX(),event.getPos().getY(),event.getPos().getZ(),event.getTarget(),event.getEntity());
}
public static void execute(
LevelAccessor world,
double x,
double y,
double z,
Entity entity,
Entity sourceentity
) {
execute(null,world,x,y,z,entity,sourceentity);
}
private static void execute(
@Nullable Event event,
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
if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY).getItem() == MinecraftEarthModModItems.MUD_BUCKET.get()) {if (entity instanceof Pig||entity instanceof DriedMuddyPigEntity) {
DirtyAPigProcedure.execute(world,x,y,z,entity)
;
}}
}
}
