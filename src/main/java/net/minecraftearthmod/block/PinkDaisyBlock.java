

package net.minecraftearthmod.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class PinkDaisyBlock extends FlowerBlock
{
public PinkDaisyBlock() {
super(MobEffects.SATURATION, 0,
BlockBehaviour.Properties.of(Material.PLANT)
.sound(SoundType.GRASS)
.instabreak()
.noCollission()
);
}
@Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
return 100;
}
@Override public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
return 60;
}
@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
List<ItemStack> dropsOriginal = super.getDrops(state, builder);
if(!dropsOriginal.isEmpty())
return dropsOriginal;
return Collections.singletonList(new ItemStack(this));
}
}