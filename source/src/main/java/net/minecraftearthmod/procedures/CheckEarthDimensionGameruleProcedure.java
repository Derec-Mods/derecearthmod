package net.minecraftearthmod.procedures;

import net.minecraftearthmod.world.DoEarthDimensionGameRule;
import net.minecraftearthmod.MinecraftEarthModModElements;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;

import java.util.Map;

@MinecraftEarthModModElements.ModElement.Tag
public class CheckEarthDimensionGameruleProcedure extends MinecraftEarthModModElements.ModElement {
	public CheckEarthDimensionGameruleProcedure(MinecraftEarthModModElements instance) {
		super(instance, 206);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency world for procedure CheckEarthDimensionGamerule!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return ((world instanceof World) ? ((World) world).getGameRules().getBoolean(DoEarthDimensionGameRule.gamerule) : false);
	}
}
