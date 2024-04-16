package net.minecraftearthmod.procedures;

import net.minecraft.world.entity.Entity;

public class SetEggTimerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("eggtimer", 0);
	}
}
