
package net.minecraftearthmod.item;

import net.minecraft.network.chat.Component;

public class MudItem extends BucketItem {

	public MudItem() {
		super(MinecraftEarthModModFluids.MUD,
			new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON)
			.tab(CreativeModeTab.TAB_MISC));
	}

}
