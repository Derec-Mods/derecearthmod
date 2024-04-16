

package net.minecraftearthmod.block;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;

public class RubyShopBlockBlock extends
Block
{
public RubyShopBlockBlock() {
super(
BlockBehaviour.Properties.of(Material.METAL)
.sound(SoundType.METAL)
.strength(5f, 10f)
.requiresCorrectToolForDrops()
);
}
@Override public void appendHoverText(ItemStack itemstack, BlockGetter world, List<Component> list, TooltipFlag flag) {
super.appendHoverText(itemstack, world, list, flag);
list.add(Component.literal("Right click on me to open the Ruby Shop!"));
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
if(entity instanceof ServerPlayer player) {
NetworkHooks.openScreen(player, new MenuProvider() {
@Override public Component getDisplayName() {
return Component.literal("Ruby Shop Block");
}
@Override public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
return new RubyShopMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
}
}, pos);
}
return InteractionResult.SUCCESS;
}
}