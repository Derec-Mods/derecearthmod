

package net.minecraftearthmod.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class ButtercupBlock extends FlowerBlock
{
public ButtercupBlock() {
super(MobEffects.SATURATION, 0,
BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_YELLOW)
.sound(SoundType.GRASS)
.instabreak()
.noCollission()
);
}
@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
List<ItemStack> dropsOriginal = super.getDrops(state, builder);
if(!dropsOriginal.isEmpty())
return dropsOriginal;
return Collections.singletonList(new ItemStack(this));
}
@Override public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
super.use(blockstate, world, pos, entity, hand, hit);
FillBottleProcedure.execute(
world,pos.getX(),pos.getY(),pos.getZ(),entity
);
return InteractionResult.SUCCESS;
}
}