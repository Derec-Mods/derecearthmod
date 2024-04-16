package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class FurnaceGolemLightUpdateTickProcedure {
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
if (!(entity instanceof FurnaceGolemEntity)) {world.setBlock(new BlockPos(x,y,z), Blocks.AIR.defaultBlockState(), 3);}
}
}
