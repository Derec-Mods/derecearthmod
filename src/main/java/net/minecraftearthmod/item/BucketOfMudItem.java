

package net.minecraftearthmod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class BucketOfMudItem extends Item {

	public BucketOfMudItem() {
		super(new Item.Properties()
				.tab(null)
				.stacksTo(1)
				.rarity(Rarity.COMMON)
		);
	}

	@Override public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}








	@Override public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Legacy"));
	}










}
