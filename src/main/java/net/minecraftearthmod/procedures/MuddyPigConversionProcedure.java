package net.minecraftearthmod.procedures;

import net.minecraftearthmod.init.MinecraftEarthModModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class MuddyPigConversionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == MinecraftEarthModModBlocks.MUD.get()) {
			DirtyAPigProcedure.execute(world, x, y, z, entity);
		}
	}
}
