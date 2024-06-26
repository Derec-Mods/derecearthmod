package net.minecraftearthmod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraftearthmod.init.MinecraftEarthModModBlocks;
import net.minecraftearthmod.entity.MoolipEntity;
import net.minecraftearthmod.entity.MoobloomEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class MoobloomPlantFlowerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double ran = 0;
		double ran2 = 0;
		ran = Math.random();
		if (entity instanceof MoobloomEntity) {
			if (ran <= 0.0005) {
				if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.GRASS_BLOCK) {
					ran2 = Math.random();
					if (ran2 <= 0.05 && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						world.setBlock(BlockPos.containing(x, y, z), MinecraftEarthModModBlocks.BUTTERCUP.get().defaultBlockState(), 3);
					}
					if (ran2 > 0.05 && ran2 <= 0.25 && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"setblock ~ ~ ~ minecraft:sunflower[half=lower]");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"setblock ~ ~1 ~ minecraft:sunflower[half=upper]");
					}
					if (ran2 > 0.25 && ran2 <= 1 && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						world.setBlock(BlockPos.containing(x, y, z), Blocks.DANDELION.defaultBlockState(), 3);
					}
				}
			}
		}
		if (entity instanceof MoolipEntity) {
			if (ran <= 0.0005) {
				if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.GRASS_BLOCK) {
					ran2 = Math.random();
					if (ran2 <= 0.05 && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						world.setBlock(BlockPos.containing(x, y, z), MinecraftEarthModModBlocks.PINK_DAISY.get().defaultBlockState(), 3);
					}
					if (ran2 > 0.05 && ran2 <= 0.25 && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"setblock ~ ~ ~ minecraft:lilac[half=lower]");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"setblock ~ ~1 ~ minecraft:lilac[half=upper]");
					}
					if (ran2 > 0.25 && ran2 <= 1 && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						world.setBlock(BlockPos.containing(x, y, z), Blocks.PINK_TULIP.defaultBlockState(), 3);
					}
				}
			}
		}
	}
}
