package net.minecraftearthmod.procedures;

import net.minecraftearthmod.network.MinecraftEarthModModVariables;

import net.minecraft.world.level.LevelAccessor;

public class GetSpawnGolemsProcedure {
	public static boolean execute(LevelAccessor world) {
		return MinecraftEarthModModVariables.MapVariables.get(world).SpawnGolems;
	}
}
