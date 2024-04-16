package net.minecraftearthmod.procedures;

import net.minecraft.world.entity.Entity;

public class WolfySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putString("sit", "standing");
	}
}
