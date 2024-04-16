

package net.minecraftearthmod.block;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;

public class CarvedMelonBlock extends
Block
{
public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
public CarvedMelonBlock() {
super(
BlockBehaviour.Properties.of(Material.VEGETABLE)
.sound(SoundType.WOOD)
.strength(1f)
.requiresCorrectToolForDrops()
);
this.registerDefaultState(this.stateDefinition.any()
.setValue(FACING, Direction.NORTH)
);
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
AxeItem
tieredItem)
return tieredItem.getTier().getLevel() >= 1;
return false;
}
@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
List<ItemStack> dropsOriginal = super.getDrops(state, builder);
if(!dropsOriginal.isEmpty())
return dropsOriginal;
return Collections.singletonList(new ItemStack(this, 1));
}
}