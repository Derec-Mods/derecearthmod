package net.minecraftearthmod.procedures;

import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.entity.Entity;

import java.util.Map;

public class WolfTameProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency entity for procedure WolfTame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (!(((entity.getPersistentData().getString("isTame"))).equals("yes")));
	}
}
