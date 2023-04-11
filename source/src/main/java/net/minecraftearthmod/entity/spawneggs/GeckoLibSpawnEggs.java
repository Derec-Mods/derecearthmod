package net.minecraftearthmod.entity.spawneggs;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraftearthmod.init.MinecraftEarthModModEntities;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class GeckoLibSpawnEggs {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MinecraftEarthModMod.MODID);

	public static final RegistryObject<Item> BOULDER_ZOMBIE = REGISTRY.register("boulder_zombie_spawn_egg",
			() -> new ForgeSpawnEggItem(MinecraftEarthModModEntities.BOULDER_ZOMBIE, -13421773, -13434880, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}
