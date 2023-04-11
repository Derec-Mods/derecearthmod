package net.minecraftearthmod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraftearthmod.init.MinecraftEarthModModEntities;
import net.minecraftearthmod.init.MinecraftEarthModModBlocks;
import net.minecraftearthmod.entity.MelonGolemEntity;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CreateMelonGolemProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.MELON || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == MinecraftEarthModModBlocks.CARVED_MELON.get()) {
			if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.SNOW_BLOCK) {
				if ((world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == Blocks.SNOW_BLOCK) {
					world.destroyBlock(new BlockPos(x, y, z), false);
					world.destroyBlock(new BlockPos(x, y - 1, z), false);
					world.destroyBlock(new BlockPos(x, y - 2, z), false);
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new MelonGolemEntity(MinecraftEarthModModEntities.MELON_GOLEM.get(), _level);
						entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
				}
			}
		}
	}
}
