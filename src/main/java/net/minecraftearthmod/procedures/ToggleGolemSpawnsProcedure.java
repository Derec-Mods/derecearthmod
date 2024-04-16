package net.minecraftearthmod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;


public class ToggleGolemSpawnsProcedure {
public static void execute(
LevelAccessor world
) {
MinecraftEarthModModVariables.MapVariables.get(world).SpawnGolems = !MinecraftEarthModModVariables.MapVariables.get(world).SpawnGolems;
MinecraftEarthModModVariables.MapVariables.get(world).syncData(world);
}
}
