package net.minecraftearthmod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraftearthmod.init.MinecraftEarthModModItems;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class GiveAttackBoostProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double random = 0;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(MinecraftEarthModModItems.RUBY.get())) : false) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(MinecraftEarthModModItems.RUBY.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			random = Math.random() * 100;
			MinecraftEarthModMod.LOGGER.info(random);
			if (random > 0 && random <= 20) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"give @p minecraft:potion{Potion:\"minecraft:water\",CustomPotionEffects:[{Id:5,Duration:12000,ShowParticles:0b}],display:{Name:\"\"Attack Boost I\"\",Lore:[\"Increases your attack damage for 10 minutes\"]}}");
			}
			if (random > 20 && random <= 40) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"give @p minecraft:potion{Potion:\"minecraft:water\",CustomPotionEffects:[{Id:23,Amplifier:19,ShowParticles:0b}],display:{Name:\"\"Food Boost I\"\",Lore:[\"Gives you a quick food bar boost\"]}}");
			}
			if (random > 40 && random <= 60) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"give @p minecraft:potion{Potion:\"minecraft:water\",CustomPotionEffects:[{Id:3,Duration:12000,ShowParticles:0b}],display:{Name:\"\"Mining Boost I\"\",Lore:[\"Increase mining speed for 10 minutes\"]}}");
			}
			if (random > 60 && random <= 80) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"give @p minecraft:potion{Potion:\"minecraft:water\",CustomPotionEffects:[{Id:21,Amplifier:4,Duration:12000,ShowParticles:0b}],display:{Name:\"\"Health Boost I\"\",Lore:[\"Increases health temporarily\"]}}");
			}
			if (random > 80 && random <= 100) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"give @p minecraft:potion{Potion:\"minecraft:water\",CustomPotionEffects:[{Id:11,Duration:12000,ShowParticles:0b},{Id:12,Duration:12000,ShowParticles:0b}],display:{Name:\"\"Defense Boost I\"\",Lore:[\"Increases damage resistance for 10 minutes \"]}}");
			}
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chest.locked")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chest.locked")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}
