package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class BuyKeyProcedure {
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
if (new Object(){
public int getAmount(int sltid) {
if(entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
if(stack != null)
return stack.getCount();
}
return 0;
}
}.getAmount(0)==32) {MinecraftEarthModModVariables.MapVariables.get(world).boughtkey = 1;
MinecraftEarthModModVariables.MapVariables.get(world).syncData(world);if(entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
((Slot) _slots.get(0)).set(ItemStack.EMPTY);
_player.containerMenu.broadcastChanges();
}if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, new BlockPos(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.portal.travel")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.portal.travel")),
SoundSource.NEUTRAL, 1, 1, false);
}
}if (entity instanceof Player _player) {
ItemStack _setstack = new ItemStack(MinecraftEarthModModItems.MINECRAFT_EARTH_DIMENSION.get());
_setstack.setCount(1);
ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
}}else{if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, new BlockPos(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chest.locked")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chest.locked")),
SoundSource.NEUTRAL, 1, 1, false);
}
}}
}
}
