package net.minecraftearthmod.procedures;

import net.minecraft.world.entity.Entity;

public class WolfTameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return !(entity.getPersistentData().getString("isTame")).equals("yes");
	}
}
