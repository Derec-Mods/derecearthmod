package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class CheckForMudonTopProcedure {
public static void execute(
LevelAccessor world,
double x,
double y,
double z
) {
if ((world.getFluidState(new BlockPos(x,y+1,z)).createLegacyBlock()).getBlock() == MinecraftEarthModModBlocks.MUD.get()) {if ((world.getFluidState(new BlockPos(x,y+1,z)).createLegacyBlock()).getFluidState().isSource()) {world.setBlock(new BlockPos(x,y+1,z), Blocks.AIR.defaultBlockState(), 3);{
BlockEntity _ent = world.getBlockEntity(new BlockPos(x,y,z));
int _amount = 500;
if (_ent != null)
_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability ->
capability.receiveEnergy(_amount, false));
}
}}
}
}
