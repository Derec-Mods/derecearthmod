package net.minecraftearthmod.procedures;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraftearthmod.MinecraftEarthModModVariables;
import net.minecraftearthmod.MinecraftEarthModModElements;

import java.util.Map;
import java.util.Collections;

@MinecraftEarthModModElements.ModElement.Tag
public class FirstLoadAdvancementProcedure extends MinecraftEarthModModElements.ModElement {
	public FirstLoadAdvancementProcedure(MinecraftEarthModModElements instance) {
		super(instance, 201);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		MinecraftEarthModModVariables.RunningEarthMod = (boolean) (true);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		this.executeProcedure(Collections.emptyMap());
	}
}
