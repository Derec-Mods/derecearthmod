package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class GetSpawnGolemsProcedure {
public static boolean execute(
LevelAccessor world
) {
return
MinecraftEarthModModVariables.MapVariables.get(world).SpawnGolems;
}
}
