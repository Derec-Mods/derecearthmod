

package net.minecraftearthmod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class RubyItem extends Item {

	public RubyItem() {
		super(new Item.Properties()
				.tab(CreativeModeTab.TAB_MISC)
				.stacksTo(64)
				.rarity(Rarity.UNCOMMON)
		);
	}

	@Override public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}








	@Override public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("A currency gem"));
		list.add(Component.literal("similar to the emerald"));
	}










}
