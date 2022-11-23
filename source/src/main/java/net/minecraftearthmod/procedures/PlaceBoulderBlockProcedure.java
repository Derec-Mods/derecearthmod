package net.minecraftearthmod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;

import net.minecraftearthmod.init.MinecraftEarthModModBlocks;
import net.minecraftearthmod.entity.BoulderZombieEntity;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlaceBoulderBlockProcedure {
	@SubscribeEvent
	public static void onEntitySetsAttackTarget(LivingSetAttackTargetEvent event) {
		execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getTarget(),
				event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof BoulderZombieEntity) {
			if (entity instanceof Player) {
				if (!((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.AIR)) {
					world.setBlock(new BlockPos(x, y, z), MinecraftEarthModModBlocks.BOULDER_ZOMBIE_CLIMBING_BLOCK.get().defaultBlockState(), 3);
				}
				if (!((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.AIR)) {
					world.setBlock(new BlockPos(x, y, z), MinecraftEarthModModBlocks.BOULDER_ZOMBIE_CLIMBING_BLOCK.get().defaultBlockState(), 3);
				}
			}
		}
	}
}
