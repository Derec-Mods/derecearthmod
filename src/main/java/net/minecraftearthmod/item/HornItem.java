

package net.minecraftearthmod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class HornItem extends Item {

	public HornItem() {
		super(new Item.Properties()
				.tab(CreativeModeTab.TAB_MATERIALS)
				.stacksTo(64)
				.rarity(Rarity.COMMON)
		);
	}

	@Override public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}








	@Override public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Now you can blow it!"));
	}

	@Override public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();


    

    BlowProcedure.execute(world,x,y,z)
;
		return ar;
	}









}
