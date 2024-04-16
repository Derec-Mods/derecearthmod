package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class CheckMuddyPigCleanProcedure {
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
if (entity.isInWater()) {
CleanAPigProcedure.execute(world,x,y,z,entity)
;
}
}
}
