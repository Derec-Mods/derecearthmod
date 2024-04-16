package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class MudConverterBucketTakeProcedure {
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
if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem():ItemStack.EMPTY).getItem() == MinecraftEarthModModItems.CONVERTIBLE_MUD.get()) {if (entity instanceof Player _player) {
ItemStack _stktoremove = new ItemStack(MinecraftEarthModModItems.CONVERTIBLE_MUD.get());
_player.getInventory()
.clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
}if (world instanceof Level _level) {
if (!_level.isClientSide()) {
_level.playSound(null, new BlockPos(x,y,z),
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.slime_block.place")),
SoundSource.NEUTRAL, 1, 1);
} else {
_level.playLocalSound(x, y, z,
ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.slime_block.place")),
SoundSource.NEUTRAL, 1, 1, false);
}
}{
BlockEntity _ent = world.getBlockEntity(new BlockPos(x,y,z));
int _amount = 1000;
if (_ent != null)
_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability ->
capability.receiveEnergy(_amount, false));
}
}
}
}
