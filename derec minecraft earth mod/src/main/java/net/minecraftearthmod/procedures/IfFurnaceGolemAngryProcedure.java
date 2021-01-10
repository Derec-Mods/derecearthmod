package net.minecraftearthmod.procedures;

import net.minecraftearthmod.MinecraftEarthModModElements;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.entity.Entity;

import java.util.Map;

@MinecraftEarthModModElements.ModElement.Tag
public class IfFurnaceGolemAngryProcedure extends MinecraftEarthModModElements.ModElement {
	public IfFurnaceGolemAngryProcedure(MinecraftEarthModModElements instance) {
		super(instance, 190);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency entity for procedure IfFurnaceGolemAngry!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getPersistentData().getBoolean("pissed"))) {
			return (true);
		}
		return (false);
	}
}
