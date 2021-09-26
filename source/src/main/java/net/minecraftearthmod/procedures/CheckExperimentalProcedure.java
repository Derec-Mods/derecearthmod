package net.minecraftearthmod.procedures;

import net.minecraftearthmod.world.ExperimentalModeGameRule;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.world.IWorld;

import java.util.Map;

public class CheckExperimentalProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency world for procedure CheckExperimental!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return (world.getWorldInfo().getGameRulesInstance().getBoolean(ExperimentalModeGameRule.gamerule));
	}
}
