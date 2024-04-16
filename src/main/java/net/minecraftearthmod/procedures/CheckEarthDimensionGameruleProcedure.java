package net.minecraftearthmod.procedures;

import net.minecraftearthmod.init.MinecraftEarthModModGameRules;

import net.minecraft.world.level.LevelAccessor;

public class CheckEarthDimensionGameruleProcedure {
	public static boolean execute(LevelAccessor world) {
		return world.getLevelData().getGameRules().getBoolean(MinecraftEarthModModGameRules.DOEARTHDIMENSION);
	}
}
