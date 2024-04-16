package net.minecraftearthmod.procedures;

import net.minecraftearthmod.item.RubyItem;
import net.minecraftearthmod.MinecraftEarthModModElements;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec2f;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import java.util.Map;

@MinecraftEarthModModElements.ModElement.Tag
public class GiveAttackBoostProcedure extends MinecraftEarthModModElements.ModElement {
	public GiveAttackBoostProcedure(MinecraftEarthModModElements instance) {
		super(instance, 41);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure GiveAttackBoost!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure GiveAttackBoost!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure GiveAttackBoost!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure GiveAttackBoost!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure GiveAttackBoost!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double random = 0;
		if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(RubyItem.block, (int) (1))) : false)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(RubyItem.block, (int) (1)).getItem() == p.getItem(), (int) 1);
			random = (double) (Math.random() * 100);
			System.out.println((random));
			if ((((random) > 0) && ((random) <= 20))) {
				if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
					world.getWorld().getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.field_213139_a_, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
							"give @p minecraft:potion{Potion:\"minecraft:water\",CustomPotionEffects:[{Id:5,Duration:12000,ShowParticles:0b}],display:{Name:\"\\\"Attack Boost I\\\"\",Lore:[\"Increases your attack damage for 10 minutes\"]}}");
				}
			}
			if ((((random) > 20) && ((random) <= 40))) {
				if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
					world.getWorld().getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.field_213139_a_, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
							"give @p minecraft:potion{Potion:\"minecraft:water\",CustomPotionEffects:[{Id:23,Amplifier:19,ShowParticles:0b}],display:{Name:\"\\\"Food Boost I\\\"\",Lore:[\"Gives you a quick food bar boost\"]}}");
				}
			}
			if ((((random) > 40) && ((random) <= 60))) {
				if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
					world.getWorld().getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.field_213139_a_, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
							"give @p minecraft:potion{Potion:\"minecraft:water\",CustomPotionEffects:[{Id:3,Duration:12000,ShowParticles:0b}],display:{Name:\"\\\"Mining Boost I\\\"\",Lore:[\"Increase mining speed for 10 minutes\"]}}");
				}
			}
			if ((((random) > 60) && ((random) <= 80))) {
				if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
					world.getWorld().getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.field_213139_a_, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
							"give @p minecraft:potion{Potion:\"minecraft:water\",CustomPotionEffects:[{Id:21,Amplifier:4,Duration:12000,ShowParticles:0b}],display:{Name:\"\\\"Health Boost I\\\"\",Lore:[\"Increases health temporarily\"]}}");
				}
			}
			if ((((random) > 80) && ((random) <= 100))) {
				if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
					world.getWorld().getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.field_213139_a_, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
							"give @p minecraft:potion{Potion:\"minecraft:water\",CustomPotionEffects:[{Id:11,Duration:12000,ShowParticles:0b},{Id:12,Duration:12000,ShowParticles:0b}],display:{Name:\"\\\"Defense Boost I\\\"\",Lore:[\"Increases damage resistance for 10 minutes \"]}}");
				}
			}
		}
	}
}
