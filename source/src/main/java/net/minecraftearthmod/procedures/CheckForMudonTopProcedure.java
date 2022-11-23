package net.minecraftearthmod.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraftearthmod.init.MinecraftEarthModModBlocks;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class CheckForMudonTopProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getFluidState(new BlockPos(x, y + 1, z)).createLegacyBlock()).getBlock() == MinecraftEarthModModBlocks.MUD.get()) {
			if ((world.getFluidState(new BlockPos(x, y + 1, z)).createLegacyBlock()).getFluidState().isSource()) {
				world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				{
					BlockEntity _ent = world.getBlockEntity(new BlockPos(x, y, z));
					int _amount = 500;
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
				}
			}
		}
	}
}
