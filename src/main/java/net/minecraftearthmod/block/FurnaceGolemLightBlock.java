

package net.minecraftearthmod.block;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;

public class FurnaceGolemLightBlock extends
Block
implements EntityBlock
{
public FurnaceGolemLightBlock() {
super(
BlockBehaviour.Properties.of(Material.BARRIER)
.sound(SoundType.GRAVEL)
.strength(-1, 3600000)
.lightLevel(s -> 15)
.noCollission()
.noOcclusion()
.isRedstoneConductor((bs, br, bp) -> false)
);
}
@Override public void appendHoverText(ItemStack itemstack, BlockGetter world, List<Component> list, TooltipFlag flag) {
super.appendHoverText(itemstack, world, list, flag);
list.add(Component.literal("You should not have this"));
}
@Override public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
return adjacentBlockState.getBlock() == this ? true : super.skipRendering(state, adjacentBlockState, side);
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
@Override public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
return context.getItemInHand().getItem() != this.asItem();
}
@Override public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
return BlockPathTypes.OPEN;
}
@Override public PushReaction getPistonPushReaction(BlockState state) {
return PushReaction.IGNORE;
}
@Override public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
List<ItemStack> dropsOriginal = super.getDrops(state, builder);
if(!dropsOriginal.isEmpty())
return dropsOriginal;
return Collections.singletonList(new ItemStack(this, 1));
}
@Override public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
super.onPlace(blockstate, world, pos, oldState, moving);
world.scheduleTick(pos, this, 10);
SetTickProcedure.execute(
world,pos.getX(),pos.getY(),pos.getZ()
);
}
@Override public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
RemoveLightProcedure.execute(
world,pos.getX(),pos.getY(),pos.getZ()
);
}
@Override public void tick
(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
super.tick(blockstate, world, pos, random);
int x = pos.getX();
int y = pos.getY();
int z = pos.getZ();
RemoveLightProcedure.execute(world,x,y,z)
;
world.scheduleTick(pos, this, 10);
}
@Override public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
super.entityInside(blockstate, world, pos, entity);
SetTickProcedure.execute(
world,pos.getX(),pos.getY(),pos.getZ()
);
}
@Override public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
super.stepOn(world, pos, blockstate, entity);
RemoveLightProcedure.execute(
world,pos.getX(),pos.getY(),pos.getZ()
);
}
@Override
public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
super.use(blockstate, world, pos, entity, hand, hit);
int x = pos.getX();
int y = pos.getY();
int z = pos.getZ();
double hitX = hit.getLocation().x;
double hitY = hit.getLocation().y;
double hitZ = hit.getLocation().z;
Direction direction = hit.getDirection();
RemoveLightProcedure.execute(world,x,y,z)
;
return InteractionResult.SUCCESS;
}
@Override public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
BlockEntity tileEntity = worldIn.getBlockEntity(pos);
return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
}
@Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
return new FurnaceGolemLightBlockEntity(pos, state);
}
@Override
public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
super.triggerEvent(state, world, pos, eventID, eventParam);
BlockEntity blockEntity = world.getBlockEntity(pos);
return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
}
@Override public boolean hasAnalogOutputSignal(BlockState state) {
return true;
}
@Override public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
BlockEntity tileentity = world.getBlockEntity(pos);
if (tileentity instanceof FurnaceGolemLightBlockEntity be)
return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
else
return 0;
}
}