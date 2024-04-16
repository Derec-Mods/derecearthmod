

package net.minecraftearthmod.block;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;

public class RubyBlockBlock extends
Block
{
public RubyBlockBlock() {
super(
BlockBehaviour.Properties.of(Material.METAL)
.sound(SoundType.METAL)
.strength(5f, 6f)
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
return Collections.singletonList(new ItemStack(this, 1));
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
CheckShopProcedure.execute(world,x,y,z,entity)
;
return InteractionResult.SUCCESS;
}
}