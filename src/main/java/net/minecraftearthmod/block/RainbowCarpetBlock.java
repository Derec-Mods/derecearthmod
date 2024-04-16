

package net.minecraftearthmod.block;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;

public class RainbowCarpetBlock extends
Block
{
public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
public RainbowCarpetBlock() {
super(
BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.WOOL)
.sound(SoundType.WOOL)
.strength(0.1f)
.noOcclusion()
.isRedstoneConductor((bs, br, bp) -> false)
);
this.registerDefaultState(this.stateDefinition.any()
.setValue(FACING, Direction.NORTH)
);
}
@Override public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
return true;
}
@Override public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
return 0;
}
@Override public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
return Shapes.empty();
}
@Override public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
return
switch (state.getValue(FACING)) {
default ->
box(0, 0, 0,
16, 1, 16)
;
case NORTH ->
box(0, 0, 0,
16, 1, 16)
;
case EAST ->
box(0, 0, 0,
16, 1, 16)
;
case WEST ->
box(0, 0, 0,
16, 1, 16)
;
}
; }
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
@Override public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
return 1;
}
@Override public PushReaction getPistonPushReaction(BlockState state) {
return PushReaction.DESTROY;
}
@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
List<ItemStack> dropsOriginal = super.getDrops(state, builder);
if(!dropsOriginal.isEmpty())
return dropsOriginal;
return Collections.singletonList(new ItemStack(this, 1));
}
}