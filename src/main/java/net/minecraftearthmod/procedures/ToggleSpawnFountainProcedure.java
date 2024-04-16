package net.minecraftearthmod.procedures;

import net.minecraftearthmod.network.MinecraftEarthModModVariables;

import net.minecraft.world.level.LevelAccessor;

public class ToggleSpawnFountainProcedure {
	public static void execute(LevelAccessor world) {
		MinecraftEarthModModVariables.MapVariables.get(world).SpawnMudStructure = !MinecraftEarthModModVariables.MapVariables.get(world).SpawnMudStructure;
		MinecraftEarthModModVariables.MapVariables.get(world).syncData(world);
	}
}
