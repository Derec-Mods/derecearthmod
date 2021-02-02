
package net.minecraftearthmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraftearthmod.block.ChestTappableBlock;
import net.minecraftearthmod.MinecraftEarthModModElements;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@MinecraftEarthModModElements.ModElement.Tag
public class TappablesTabItemGroup extends MinecraftEarthModModElements.ModElement {
	public TappablesTabItemGroup(MinecraftEarthModModElements instance) {
		super(instance, 110);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtappables_tab") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ChestTappableBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
