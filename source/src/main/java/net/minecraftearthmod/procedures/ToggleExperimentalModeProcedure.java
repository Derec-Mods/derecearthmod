package net.minecraftearthmod.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraftearthmod.world.ExperimentalModeGameRule;
import net.minecraftearthmod.MinecraftEarthModModVariables;
import net.minecraftearthmod.MinecraftEarthModModElements;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import java.util.Map;
import java.util.Iterator;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

import com.google.gson.JsonObject;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

@MinecraftEarthModModElements.ModElement.Tag
public class ToggleExperimentalModeProcedure extends MinecraftEarthModModElements.ModElement {
	public ToggleExperimentalModeProcedure(MinecraftEarthModModElements instance) {
		super(instance, 196);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency entity for procedure ToggleExperimentalMode!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency world for procedure ToggleExperimentalMode!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		File earthmobsconfig = new File(((Minecraft.getInstance().gameDir) + "" + ("\\config")), File.separator + "earthmobsconfig.json");
		if ((MinecraftEarthModModVariables.MapVariables.get(world).ExperimentalMode)) {
			if ((!(((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
					? ((ServerPlayerEntity) entity).getAdvancements()
							.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("minecraft_earth_mod:experimenter")))
							.isDone()
					: false))) {
				if (entity instanceof ServerPlayerEntity) {
					Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
							.getAdvancement(new ResourceLocation("minecraft_earth_mod:experimenter"));
					AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
					if (!_ap.isDone()) {
						Iterator _iterator = _ap.getRemaningCriteria().iterator();
						while (_iterator.hasNext()) {
							String _criterion = (String) _iterator.next();
							((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
						}
					}
				}
			}
			if (world instanceof World) {
				((World) world).getGameRules().get(ExperimentalModeGameRule.gamerule).set((false), ((World) world).getServer());
			}
			MinecraftEarthModModVariables.MapVariables
					.get(world).ExperimentalMode = (boolean) (!(MinecraftEarthModModVariables.MapVariables.get(world).ExperimentalMode));
			MinecraftEarthModModVariables.MapVariables.get(world).syncData(world);
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent(
							(("Experimental Mode Set To: ") + "" + ((MinecraftEarthModModVariables.MapVariables.get(world).ExperimentalMode)))),
							ChatType.SYSTEM, Util.DUMMY_UUID);
			}
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			JsonObject obj = new JsonObject();
			obj.addProperty("experimentalmode", (MinecraftEarthModModVariables.MapVariables.get(world).ExperimentalMode));
			try {
				FileWriter earthmobsconfigfw = new FileWriter(earthmobsconfig);
				earthmobsconfigfw.write(gson.toJson(obj));
				earthmobsconfigfw.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		} else {
			if (world instanceof World) {
				((World) world).getGameRules().get(ExperimentalModeGameRule.gamerule).set((true), ((World) world).getServer());
			}
			MinecraftEarthModModVariables.MapVariables
					.get(world).ExperimentalMode = (boolean) (!(MinecraftEarthModModVariables.MapVariables.get(world).ExperimentalMode));
			MinecraftEarthModModVariables.MapVariables.get(world).syncData(world);
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent(
							(("Experimental Mode Set To: ") + "" + ((MinecraftEarthModModVariables.MapVariables.get(world).ExperimentalMode)))),
							ChatType.SYSTEM, Util.DUMMY_UUID);
			}
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			JsonObject obj = new JsonObject();
			obj.addProperty("experimentalmode", (MinecraftEarthModModVariables.MapVariables.get(world).ExperimentalMode));
			try {
				FileWriter earthmobsconfigfw = new FileWriter(earthmobsconfig);
				earthmobsconfigfw.write(gson.toJson(obj));
				earthmobsconfigfw.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}
}
