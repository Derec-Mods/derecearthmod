

package net.minecraftearthmod.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class MudBlock extends LiquidBlock {
public MudBlock() {
super(() -> MinecraftEarthModModFluids.MUD.get(),
BlockBehaviour.Properties.of(Material.WATER)
.strength(100f)
.noCollission().noLootTable()
);
}
@Override public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
super.onPlace(blockstate, world, pos, oldState, moving);
world.scheduleTick(pos, this, 20);
}
@Override public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
super.tick(blockstate, world, pos, random);
ConvertToMudProcedure.execute(
world,pos.getX(),pos.getY(),pos.getZ()
);
world.scheduleTick(pos, this, 20);
}
}