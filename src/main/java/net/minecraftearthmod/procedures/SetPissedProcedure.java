package net.minecraftearthmod.procedures;

import net.minecraft.world.entity.Entity;

public class SetPissedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("pissed", false);
		entity.getPersistentData().putDouble("calmtimer", 7000);
	}
}
