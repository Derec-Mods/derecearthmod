package net.minecraftearthmod.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraftearthmod.MinecraftEarthModModVariables;
import net.minecraftearthmod.MinecraftEarthModModElements;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.world.IWorld;

import java.util.Map;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.google.gson.JsonObject;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

@MinecraftEarthModModElements.ModElement.Tag
public class ChangeHostileMobSpawnsProcedure extends MinecraftEarthModModElements.ModElement {
	public ChangeHostileMobSpawnsProcedure(MinecraftEarthModModElements instance) {
		super(instance, 211);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency world for procedure ChangeHostileMobSpawns!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		MinecraftEarthModModVariables.MapVariables
				.get(world).HostileMobSpawns = (boolean) (!(MinecraftEarthModModVariables.MapVariables.get(world).HostileMobSpawns));
		MinecraftEarthModModVariables.MapVariables.get(world).syncData(world);
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
			try {
				FileWriter earthmobsconfigfw = new FileWriter(earthmobsconfig);
				earthmobsconfigfw.write(mainGSONBuilderVariable.toJson(emobconfig));
				earthmobsconfigfw.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}
}
