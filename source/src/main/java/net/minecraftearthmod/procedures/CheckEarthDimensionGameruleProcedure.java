package net.minecraftearthmod.procedures;

import net.minecraftearthmod.world.DoEarthDimensionGameRule;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.world.IWorld;

import java.util.Map;

public class CheckEarthDimensionGameruleProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency world for procedure CheckEarthDimensionGamerule!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return (world.getWorldInfo().getGameRulesInstance().getBoolean(DoEarthDimensionGameRule.gamerule));
	}
}
