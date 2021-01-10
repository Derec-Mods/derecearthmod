package net.minecraftearthmod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraftearthmod.MinecraftEarthModModElements;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import java.util.Random;
import java.util.Map;

@MinecraftEarthModModElements.ModElement.Tag
public class ShearSheepProcedure extends MinecraftEarthModModElements.ModElement {
	public ShearSheepProcedure(MinecraftEarthModModElements instance) {
		super(instance, 152);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency entity for procedure ShearSheep!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency sourceentity for procedure ShearSheep!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency x for procedure ShearSheep!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency y for procedure ShearSheep!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency z for procedure ShearSheep!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency world for procedure ShearSheep!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((entity.getPersistentData().getDouble("regrow")) >= 6000)) {
			if ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(Items.SHEARS, (int) (1)).getItem())) {
				if ((!((sourceentity instanceof PlayerEntity) ? ((PlayerEntity) sourceentity).abilities.isCreativeMode : false))) {
					{
						ItemStack _ist = ((sourceentity instanceof LivingEntity)
								? ((LivingEntity) sourceentity).getHeldItemMainhand()
								: ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				}
				entity.getPersistentData().putDouble("regrow", 0);
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.shear")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.WHITE_WOOL, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (((Math.random() * 100) <= 50)) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.WHITE_WOOL, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
				if (((Math.random() * 100) <= 50)) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Blocks.WHITE_WOOL, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
			}
		} else {
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.ambient")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound(x, y, z,
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.sheep.ambient")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
		}
	}
}
