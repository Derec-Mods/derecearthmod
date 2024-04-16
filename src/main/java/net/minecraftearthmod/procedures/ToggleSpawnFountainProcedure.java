package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class ToggleSpawnFountainProcedure {
public static void execute(
LevelAccessor world
) {
MinecraftEarthModModVariables.MapVariables.get(world).SpawnMudStructure = !MinecraftEarthModModVariables.MapVariables.get(world).SpawnMudStructure;
MinecraftEarthModModVariables.MapVariables.get(world).syncData(world);
}
}
