package net.minecraftearthmod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraftearthmod.init.MinecraftEarthModModBlocks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class PinkMoobloomPlantFlowerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double ran2 = 0;
		double ran = 0;
		ran = Math.random();
		if (ran <= 0.0005) {
			if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.GRASS_BLOCK) {
				ran2 = Math.random();
				if (ran2 <= 0.05 && world.canSeeSkyFromBelowWater(new BlockPos(x, y, z))) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")),
									SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					world.setBlock(new BlockPos(x, y, z), MinecraftEarthModModBlocks.BUTTERCUP.get().defaultBlockState(), 3);
				}
				if (ran2 > 0.05 && ran2 <= 0.25 && world.canSeeSkyFromBelowWater(new BlockPos(x, y, z))) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")),
									SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",
										Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"setblock ~ ~ ~ minecraft:lilac[half=lower]");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands()
								.performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "",
										Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"setblock ~ ~1 ~ minecraft:lilac[half=upper]");
				}
				if (ran2 > 0.25 && ran2 <= 1 && world.canSeeSkyFromBelowWater(new BlockPos(x, y, z))) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z),
									ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.place")),
									SoundSource.NEUTRAL, 1, 1, false);
						}
					}
					world.setBlock(new BlockPos(x, y, z), Blocks.PINK_TULIP.defaultBlockState(), 3);
				}
			}
		}
	}
}
