package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class GetSpawnMudFountainProcedure {
public static boolean execute(
LevelAccessor world
) {
return
MinecraftEarthModModVariables.MapVariables.get(world).SpawnMudStructure;
}
}
