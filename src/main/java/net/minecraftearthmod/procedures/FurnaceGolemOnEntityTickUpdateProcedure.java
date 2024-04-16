package net.minecraftearthmod.procedures;

import net.minecraftearthmod.init.MinecraftEarthModModGameRules;
import net.minecraftearthmod.init.MinecraftEarthModModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class FurnaceGolemOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world.isEmptyBlock(BlockPos.containing(x, y + 3, z))) {
			world.setBlock(BlockPos.containing(x, y + 3, z), MinecraftEarthModModBlocks.FURNACE_GOLEM_LIGHT.get().defaultBlockState(), 3);
		}
		if (entity.getPersistentData().getDouble("calmtimer") >= 1000) {
			entity.getPersistentData().putDouble("calmtimer", 7000);
			entity.getPersistentData().putBoolean("pissed", false);
		} else {
			entity.getPersistentData().putDouble("calmtimer", (entity.getPersistentData().getDouble("calmtimer") + 1));
		}
		if (Math.random() <= 0.0001) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.TORCH));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WATER || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WATER) {
			if (!world.getLevelData().getGameRules().getBoolean(MinecraftEarthModModGameRules.WATERPROOFGOLEMS)) {
				entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), (float) 0.5);
			}
		}
	}
}
