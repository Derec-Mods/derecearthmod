package net.minecraftearthmod.procedures;

import net.minecraftearthmod.MinecraftEarthModModElements;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;

import java.util.Map;

@MinecraftEarthModModElements.ModElement.Tag
public class DropPorkchopProcedure extends MinecraftEarthModModElements.ModElement {
	public DropPorkchopProcedure(MinecraftEarthModModElements instance) {
		super(instance, 90);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency entity for procedure DropPorkchop!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency sourceentity for procedure DropPorkchop!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency x for procedure DropPorkchop!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency y for procedure DropPorkchop!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency z for procedure DropPorkchop!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency world for procedure DropPorkchop!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double rand = 0;
		rand = (double) Math.random();
		if ((entity.isBurning())) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.COOKED_PORKCHOP, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (((rand) < 0.33)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.COOKED_PORKCHOP, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (((((rand) >= 0) && ((rand) <= 0.16)) && ((EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING,
						((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) >= 1))) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.COOKED_PORKCHOP, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((((rand) >= 0.33) && ((rand) <= 0.66))) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.COOKED_PORKCHOP, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (((((rand) >= 0.33) && ((rand) <= 0.49)) && ((EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING,
						((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) >= 1))) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.COOKED_PORKCHOP, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
			}
		} else {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.PORKCHOP, (int) (1)));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
			if (((rand) < 0.33)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.PORKCHOP, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (((((rand) >= 0) && ((rand) <= 0.16)) && ((EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING,
						((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) >= 1))) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.PORKCHOP, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
			}
			if ((((rand) >= 0.33) && ((rand) <= 0.66))) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.PORKCHOP, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (((((rand) >= 0.33) && ((rand) <= 0.49)) && ((EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING,
						((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) >= 1))) {
					if (world instanceof World && !world.isRemote()) {
						ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.PORKCHOP, (int) (1)));
						entityToSpawn.setPickupDelay((int) 10);
						world.addEntity(entityToSpawn);
					}
				}
			}
		}
	}
}
