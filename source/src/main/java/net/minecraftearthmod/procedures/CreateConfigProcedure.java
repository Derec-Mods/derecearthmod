package net.minecraftearthmod.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraftearthmod.MinecraftEarthModModElements;

import java.util.Map;
import java.util.Collections;

import java.io.IOException;
import java.io.File;

@MinecraftEarthModModElements.ModElement.Tag
public class CreateConfigProcedure extends MinecraftEarthModModElements.ModElement {
	public CreateConfigProcedure(MinecraftEarthModModElements instance) {
		super(instance, 213);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		File earthmobsconfig = new File(FMLPaths.GAMEDIR.get().toString(), File.separator + "earthmobsconfig.json");
		if (!earthmobsconfig.exists()) {
			try {
				earthmobsconfig.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		this.executeProcedure(Collections.emptyMap());
	}
}
