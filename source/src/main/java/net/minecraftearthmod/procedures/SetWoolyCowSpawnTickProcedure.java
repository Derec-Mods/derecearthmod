package net.minecraftearthmod.procedures;

import net.minecraft.world.entity.Entity;

public class SetWoolyCowSpawnTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("regrow", 9000);
	}
}
