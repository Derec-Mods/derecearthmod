

package net.minecraftearthmod.item;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class BoneshardItem extends Item {
public BoneshardItem() {
super(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).stacksTo(64));
}
@Override public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
entity.startUsingItem(hand);
return new InteractionResultHolder(InteractionResult.SUCCESS, entity.getItemInHand(hand));
}
@Override public UseAnim getUseAnimation(ItemStack itemstack) {
return UseAnim.BOW;
}
@Override public int getUseDuration(ItemStack itemstack) {
return 72000;
}
@Override
public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entityLiving, int timeLeft) {
if (!world.isClientSide() && entityLiving instanceof ServerPlayer entity) {
double x = entity.getX();
double y = entity.getY();
double z = entity.getZ();
if ( true
) {
BoneshardEntity entityarrow = BoneshardEntity.shoot(world, entity, world.getRandom(), 1f, 4, 1);
itemstack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(entity.getUsedItemHand()));
entityarrow.pickup = AbstractArrow.Pickup.DISALLOWED;
RemoveBoneShardProcedure.execute(entity,itemstack)
;
}
}
}
}
