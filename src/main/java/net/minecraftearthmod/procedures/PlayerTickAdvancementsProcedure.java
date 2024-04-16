package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


@Mod.EventBusSubscriber public class PlayerTickAdvancementsProcedure {
@SubscribeEvent public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
if (event.phase == TickEvent.Phase.END) {
execute(event,event.player.level,event.player.getX(),event.player.getY(),event.player.getZ(),event.player);
}
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
if (!(entity instanceof ServerPlayer _plr0 && _plr0.level instanceof ServerLevel && _plr0.getAdvancements()
.getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft_earth_mod:experimenter"))).isDone())) {if (world.getLevelData().getGameRules().getBoolean(MinecraftEarthModModGameRules.EXPERIMENTALMODE)) {if(entity instanceof ServerPlayer _player) {
Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft_earth_mod:experimenter"));
AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
if (!_ap.isDone()) {
Iterator _iterator = _ap.getRemainingCriteria().iterator();
while(_iterator.hasNext())
_player.getAdvancements().award(_adv, (String)_iterator.next());
}
}}}if ((world.getBlockState(new BlockPos(x,y,z))).getBlock() == MinecraftEarthModModBlocks.MUD.get()) {if (!(entity instanceof ServerPlayer _plr5 && _plr5.level instanceof ServerLevel && _plr5.getAdvancements()
.getOrStartProgress(_plr5.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft_earth_mod:get_mud"))).isDone())) {if(entity instanceof ServerPlayer _player) {
Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft_earth_mod:get_mud"));
AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
if (!_ap.isDone()) {
Iterator _iterator = _ap.getRemainingCriteria().iterator();
while(_iterator.hasNext())
_player.getAdvancements().award(_adv, (String)_iterator.next());
}
}}}
}
}
