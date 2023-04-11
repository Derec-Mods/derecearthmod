package net.minecraftearthmod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraftearthmod.entity.BoulderZombieEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class BoulderZombBoulderrProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean climbing = false;
		climbing = false;
		if ((entity.getDirection()) == Direction.NORTH) {
			if (world.getBlockState(new BlockPos(x, y, z - 0.4)).canOcclude()) {
				climbing = true;
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.5, (entity.getDeltaMovement().z())));
			}
		} else if ((entity.getDirection()) == Direction.SOUTH) {
			if (world.getBlockState(new BlockPos(x, y, z + 0.4)).canOcclude()) {
				climbing = true;
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.5, (entity.getDeltaMovement().z())));
			}
		} else if ((entity.getDirection()) == Direction.EAST) {
			if (world.getBlockState(new BlockPos(x + 0.4, y, z)).canOcclude()) {
				climbing = true;
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.5, (entity.getDeltaMovement().z())));
			}
		} else if ((entity.getDirection()) == Direction.WEST) {
			if (world.getBlockState(new BlockPos(x - 0.4, y, z)).canOcclude()) {
				climbing = true;
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.5, (entity.getDeltaMovement().z())));
			}
		}
		if (climbing) {
			if (entity instanceof BoulderZombieEntity) {
				((BoulderZombieEntity) entity).setAnimation("animation.boulderZombieNEW.boulder");
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.step")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.step")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}
