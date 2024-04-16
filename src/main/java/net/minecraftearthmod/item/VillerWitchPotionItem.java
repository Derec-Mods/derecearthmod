

package net.minecraftearthmod.item;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class VillerWitchPotionItem extends Item {
public VillerWitchPotionItem() {
super(new Item.Properties().tab(null).durability(100));
}
@Override public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
entity.startUsingItem(hand);
return new InteractionResultHolder(InteractionResult.SUCCESS, entity.getItemInHand(hand));
}
@Override public UseAnim getUseAnimation(ItemStack itemstack) {
return UseAnim.NONE;
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
VillerWitchPotionEntity entityarrow = VillerWitchPotionEntity.shoot(world, entity, world.getRandom(), 1f, 0.5, 0);
itemstack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(entity.getUsedItemHand()));
entityarrow.pickup = AbstractArrow.Pickup.DISALLOWED;
}
}
}
}
