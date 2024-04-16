
package net.minecraftearthmod.item;

import net.minecraftearthmod.init.MinecraftEarthModModFluids;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BucketItem;

public class MudItem extends BucketItem {
	public MudItem() {
		super(MinecraftEarthModModFluids.MUD, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(CreativeModeTab.TAB_MISC));
	}
}
