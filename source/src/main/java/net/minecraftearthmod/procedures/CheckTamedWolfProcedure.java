package net.minecraftearthmod.procedures;

import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

public class CheckTamedWolfProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency entity for procedure CheckTamedWolf!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return ((entity instanceof TameableEntity) ? ((TameableEntity) entity).isTamed() : false);
	}
}
