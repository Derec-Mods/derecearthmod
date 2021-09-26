package net.minecraftearthmod.procedures;

import net.minecraftearthmod.MinecraftEarthModModVariables;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.world.IWorld;

import java.util.Map;

public class ChangeHostileMobSpawnsProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency world for procedure ChangeHostileMobSpawns!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		MinecraftEarthModModVariables.MapVariables
				.get(world).HostileMobSpawns = (boolean) (!MinecraftEarthModModVariables.MapVariables.get(world).HostileMobSpawns);
		MinecraftEarthModModVariables.MapVariables.get(world).syncData(world);
	}
}
