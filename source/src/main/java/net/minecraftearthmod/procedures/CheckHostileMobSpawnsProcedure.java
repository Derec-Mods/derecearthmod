package net.minecraftearthmod.procedures;

import net.minecraftearthmod.MinecraftEarthModModVariables;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;

import java.util.Map;

public class CheckHostileMobSpawnsProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency world for procedure CheckHostileMobSpawns!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return (MinecraftEarthModModVariables.MapVariables.get(world).HostileMobSpawns
				&& (!((world instanceof World) ? ((World) world).isDaytime() : false)));
	}
}
