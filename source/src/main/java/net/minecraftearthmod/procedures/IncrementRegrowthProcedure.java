package net.minecraftearthmod.procedures;

import net.minecraft.world.entity.Entity;

public class IncrementRegrowthProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("regrow") <= 6005) {
			entity.getPersistentData().putDouble("regrow", (entity.getPersistentData().getDouble("regrow") + 1));
		}
	}
}
