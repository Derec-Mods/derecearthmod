package net.minecraftearthmod.procedures;

import net.minecraft.world.entity.Entity;

public class CheckWolfSitProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getPersistentData().getString("sit")).equals("standing")) {
			return true;
		}
		return false;
	}
}
