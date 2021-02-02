package net.minecraftearthmod.procedures;

import net.minecraftearthmod.MinecraftEarthModModElements;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.entity.Entity;

import java.util.Map;

@MinecraftEarthModModElements.ModElement.Tag
public class CheckWolfSitProcedure extends MinecraftEarthModModElements.ModElement {
	public CheckWolfSitProcedure(MinecraftEarthModModElements instance) {
		super(instance, 167);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency entity for procedure CheckWolfSit!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getPersistentData().getString("sit"))).equals("standing"))) {
			return (true);
		}
		return (false);
	}
}
