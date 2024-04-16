package net.minecraftearthmod.procedures;

import net.minecraft.world.entity.Entity;

public class IfFurnaceGolemAngryProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getBoolean("pissed")) {
			return true;
		}
		return false;
	}
}
