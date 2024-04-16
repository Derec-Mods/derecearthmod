package net.minecraftearthmod.procedures;

import net.minecraftearthmod.init.MinecraftEarthModModGameRules;

import net.minecraft.world.level.LevelAccessor;

public class CheckExperimentalProcedure {
	public static boolean execute(LevelAccessor world) {
		return world.getLevelData().getGameRules().getBoolean(MinecraftEarthModModGameRules.EXPERIMENTALMODE);
	}
}
