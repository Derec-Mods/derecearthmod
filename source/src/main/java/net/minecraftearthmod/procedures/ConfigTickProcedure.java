package net.minecraftearthmod.procedures;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraftearthmod.MinecraftEarthModModVariables;
import net.minecraftearthmod.MinecraftEarthModModElements;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.world.IWorld;

import java.util.Map;
import java.util.HashMap;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.google.gson.JsonObject;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

@MinecraftEarthModModElements.ModElement.Tag
public class ConfigTickProcedure extends MinecraftEarthModModElements.ModElement {
	public ConfigTickProcedure(MinecraftEarthModModElements instance) {
		super(instance, 212);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency world for procedure ConfigTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		File earthmobsconfig = new File(FMLPaths.GAMEDIR.get().toString(), File.separator + "earthmobsconfig.json");
		if (!earthmobsconfig.exists()) {
			try {
				earthmobsconfig.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		{
			Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
			JsonObject emobconfig = new JsonObject();
			emobconfig.addProperty("hostilemobspawns", (MinecraftEarthModModVariables.MapVariables.get(world).HostileMobSpawns));
			emobconfig.addProperty("experimentalmode", (MinecraftEarthModModVariables.MapVariables.get(world).ExperimentalMode));
			try {
				FileWriter earthmobsconfigfw = new FileWriter(earthmobsconfig);
				earthmobsconfigfw.write(mainGSONBuilderVariable.toJson(emobconfig));
				earthmobsconfigfw.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}

	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			IWorld world = event.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("world", world);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
