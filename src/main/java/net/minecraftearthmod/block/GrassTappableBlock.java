

package net.minecraftearthmod.block;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;

public class GrassTappableBlock extends
Block
{
public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
public GrassTappableBlock() {
super(
BlockBehaviour.Properties.of(Material.STONE)
.sound(SoundType.GRASS)
.strength(0.5f, 50f)
.requiresCorrectToolForDrops()
);
this.registerDefaultState(this.stateDefinition.any()
.setValue(FACING, Direction.NORTH)
);
}
@Override public void appendHoverText(ItemStack itemstack, BlockGetter world, List<Component> list, TooltipFlag flag) {
super.appendHoverText(itemstack, world, list, flag);
list.add(Component.literal("Break me with a shovel!"));
}
@Override public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
return 15;
}
@Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
builder.add(FACING);
}
@Override
public BlockState getStateForPlacement(BlockPlaceContext context) {
return this.defaultBlockState()
.setValue(FACING, context.getHorizontalDirection().getOpposite())
;
}
public BlockState rotate(BlockState state, Rotation rot) {
return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
}
public BlockState mirror(BlockState state, Mirror mirrorIn) {
return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
}
@Override public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
if(player.getInventory().getSelected().getItem() instanceof
ShovelItem
tieredItem)
return tieredItem.getTier().getLevel() >= 0;
return false;
}
@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
List<ItemStack> dropsOriginal = super.getDrops(state, builder);
if(!dropsOriginal.isEmpty())
return dropsOriginal;
return Collections.singletonList(new ItemStack(this, 1));
}
}