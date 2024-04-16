package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class MuddyPigConversionProcedure {
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
if ((world.getBlockState(new BlockPos(x,y,z))).getBlock() == MinecraftEarthModModBlocks.MUD.get()) {
DirtyAPigProcedure.execute(world,x,y,z,entity)
;
}
}
}
