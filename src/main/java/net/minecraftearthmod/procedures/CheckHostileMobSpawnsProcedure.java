package net.minecraftearthmod.procedures;

import net.minecraftearthmod.network.MinecraftEarthModModVariables;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

public class CheckHostileMobSpawnsProcedure {
	public static boolean execute(LevelAccessor world) {
		return MinecraftEarthModModVariables.MapVariables.get(world).HostileMobSpawns && !(world instanceof Level _lvl0 && _lvl0.isDay());
	}
}
