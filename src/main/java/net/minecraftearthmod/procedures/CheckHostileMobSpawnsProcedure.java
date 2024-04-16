package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class CheckHostileMobSpawnsProcedure {
public static boolean execute(
LevelAccessor world
) {
return
MinecraftEarthModModVariables.MapVariables.get(world).HostileMobSpawns&&!(world instanceof Level _lvl0 && _lvl0.isDay());
}
}
