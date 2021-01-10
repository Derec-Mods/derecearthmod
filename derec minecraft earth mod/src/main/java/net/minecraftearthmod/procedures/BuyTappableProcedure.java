package net.minecraftearthmod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraftearthmod.item.RubyItem;
import net.minecraftearthmod.block.StoneTappableBlock;
import net.minecraftearthmod.block.SpruceTappableBlock;
import net.minecraftearthmod.block.OakTappableBlock;
import net.minecraftearthmod.block.GrassTappableBlock;
import net.minecraftearthmod.block.ChestTappableBlock;
import net.minecraftearthmod.block.BirchTappableBlock;
import net.minecraftearthmod.MinecraftEarthModModVariables;
import net.minecraftearthmod.MinecraftEarthModModElements;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@MinecraftEarthModModElements.ModElement.Tag
public class BuyTappableProcedure extends MinecraftEarthModModElements.ModElement {
	public BuyTappableProcedure(MinecraftEarthModModElements instance) {
		super(instance, 82);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency entity for procedure BuyTappable!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency x for procedure BuyTappable!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency y for procedure BuyTappable!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency z for procedure BuyTappable!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency world for procedure BuyTappable!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double ran = 0;
		if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(RubyItem.block, (int) (1))) : false)) {
			ran = (double) (Math.random() * 100);
			MinecraftEarthModModVariables.MapVariables.get(world).paidyet = (String) "yes";
			MinecraftEarthModModVariables.MapVariables.get(world).syncData(world);
			if (((ran) <= 17)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(RubyItem.block, (int) (1));
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ChestTappableBlock.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
			if ((((ran) > 17) && ((ran) <= 34))) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(RubyItem.block, (int) (1));
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(GrassTappableBlock.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
			if ((((ran) > 34) && ((ran) <= 51))) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(RubyItem.block, (int) (1));
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(StoneTappableBlock.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
			if ((((ran) > 51) && ((ran) <= 68))) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(RubyItem.block, (int) (1));
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(BirchTappableBlock.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
			if ((((ran) > 68) && ((ran) <= 85))) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(RubyItem.block, (int) (1));
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(OakTappableBlock.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
			if ((((ran) > 85) && ((ran) <= 100))) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(RubyItem.block, (int) (1));
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SpruceTappableBlock.block, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
			}
		} else {
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chest.locked")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chest.locked")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
		}
	}
}
