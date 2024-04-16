

package net.minecraftearthmod.block;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;

public class RubyOreBlock extends
Block
{
public RubyOreBlock() {
super(
BlockBehaviour.Properties.of(Material.STONE)
.sound(SoundType.STONE)
.strength(3f)
.requiresCorrectToolForDrops()
);
}
@Override public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
return 15;
}
@Override public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
if(player.getInventory().getSelected().getItem() instanceof
PickaxeItem
tieredItem)
return tieredItem.getTier().getLevel() >= 2;
return false;
}
@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
List<ItemStack> dropsOriginal = super.getDrops(state, builder);
if(!dropsOriginal.isEmpty())
return dropsOriginal;
return Collections.singletonList(new ItemStack(MinecraftEarthModModItems.RUBY.get()));
}
@Override public boolean onDestroyedByPlayer(BlockState blockstate, Level world, BlockPos pos, Player entity, boolean willHarvest, FluidState fluid) {
boolean retval = super.onDestroyedByPlayer(blockstate, world, pos, entity, willHarvest, fluid);
RubyOreFortuneProcedure.execute(
world,pos.getX(),pos.getY(),pos.getZ(),entity
);
return retval;
}
}