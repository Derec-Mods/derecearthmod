package net.minecraftearthmod.procedures;

import net.minecraftearthmod.MinecraftEarthModModElements;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.entity.Entity;

import java.util.Map;

@MinecraftEarthModModElements.ModElement.Tag
public class WolfTameProcedure extends MinecraftEarthModModElements.ModElement {
	public WolfTameProcedure(MinecraftEarthModModElements instance) {
		super(instance, 120);
	}

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
