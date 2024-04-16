package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


@Mod.EventBusSubscriber public class ConvertMuddyPigProcedure {
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
if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY).getItem() == MinecraftEarthModModItems.MUD_FORMULA.get()) {if (entity instanceof Pig||entity instanceof DriedMuddyPigEntity) {if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, new BlockPos(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie_villager.cure")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie_villager.cure")),
SoundSource.NEUTRAL, 1, 1, false);
}
}if (sourceentity instanceof Player _player) {
ItemStack _stktoremove = new ItemStack(MinecraftEarthModModItems.MUD_FORMULA.get());
_player.getInventory()
.clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
}
DirtyAPigProcedure.execute(world,x,y,z,entity)
;
}}
}
}
