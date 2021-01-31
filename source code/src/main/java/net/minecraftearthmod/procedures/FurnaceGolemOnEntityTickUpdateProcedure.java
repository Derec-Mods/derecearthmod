package net.minecraftearthmod.procedures;

import net.minecraftearthmod.block.FurnaceGolemLightBlock;
import net.minecraftearthmod.MinecraftEarthModModElements;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;

import java.util.Map;

@MinecraftEarthModModElements.ModElement.Tag
public class FurnaceGolemOnEntityTickUpdateProcedure extends MinecraftEarthModModElements.ModElement {
	public FurnaceGolemOnEntityTickUpdateProcedure(MinecraftEarthModModElements instance) {
		super(instance, 26);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency entity for procedure FurnaceGolemOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency x for procedure FurnaceGolemOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency y for procedure FurnaceGolemOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency z for procedure FurnaceGolemOnEntityTickUpdate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency world for procedure FurnaceGolemOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((world.isAirBlock(new BlockPos((int) x, (int) (y + 1), (int) z)))) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), FurnaceGolemLightBlock.block.getDefaultState(), 3);
		}
		if (((entity.getPersistentData().getDouble("calmtimer")) >= 1000)) {
			entity.getPersistentData().putDouble("calmtimer", 7000);
			entity.getPersistentData().putBoolean("pissed", (false));
		} else {
			entity.getPersistentData().putDouble("calmtimer", ((entity.getPersistentData().getDouble("calmtimer")) + 1));
		}
	}
}
