package net.minecraftearthmod.procedures;

import net.minecraftearthmod.network.MinecraftEarthModModVariables;

import net.minecraft.world.level.LevelAccessor;

public class ChangeHostileMobSpawnsProcedure {
	public static void execute(LevelAccessor world) {
		MinecraftEarthModModVariables.MapVariables
				.get(world).HostileMobSpawns = !MinecraftEarthModModVariables.MapVariables.get(world).HostileMobSpawns;
		MinecraftEarthModModVariables.MapVariables.get(world).syncData(world);
	}
}
