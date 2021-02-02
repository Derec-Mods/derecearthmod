
package net.minecraftearthmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraftearthmod.item.RubyItem;
import net.minecraftearthmod.MinecraftEarthModModElements;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@MinecraftEarthModModElements.ModElement.Tag
public class DerecEarthMobsSpawnEggsItemGroup extends MinecraftEarthModModElements.ModElement {
	public DerecEarthMobsSpawnEggsItemGroup(MinecraftEarthModModElements instance) {
		super(instance, 169);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabderec_earth_mobs_spawn_eggs") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(RubyItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
