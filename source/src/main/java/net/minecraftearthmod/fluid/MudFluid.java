
package net.minecraftearthmod.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraftearthmod.init.MinecraftEarthModModItems;
import net.minecraftearthmod.init.MinecraftEarthModModFluids;
import net.minecraftearthmod.init.MinecraftEarthModModFluidTypes;
import net.minecraftearthmod.init.MinecraftEarthModModBlocks;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

public abstract class MudFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(
			() -> MinecraftEarthModModFluidTypes.MUD_TYPE.get(), () -> MinecraftEarthModModFluids.MUD.get(),
			() -> MinecraftEarthModModFluids.FLOWING_MUD.get()).explosionResistance(100f).bucket(() -> MinecraftEarthModModItems.MUD_BUCKET.get())
			.block(() -> (LiquidBlock) MinecraftEarthModModBlocks.MUD.get());

	private MudFluid() {
		super(PROPERTIES);
	}

	public static class Source extends MudFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends MudFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
