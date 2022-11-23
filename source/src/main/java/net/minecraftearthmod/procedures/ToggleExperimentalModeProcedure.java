package net.minecraftearthmod.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraftearthmod.network.MinecraftEarthModModVariables;
import net.minecraftearthmod.init.MinecraftEarthModModGameRules;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.MinecraftServer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import java.util.Iterator;

public class ToggleExperimentalModeProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (MinecraftEarthModModVariables.MapVariables.get(world).ExperimentalMode) {
			if (!(entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
					? _plr.getAdvancements()
							.getOrStartProgress(
									_plr.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft_earth_mod:experimenter")))
							.isDone()
					: false)) {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft_earth_mod:experimenter"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						Iterator _iterator = _ap.getRemainingCriteria().iterator();
						while (_iterator.hasNext())
							_player.getAdvancements().award(_adv, (String) _iterator.next());
					}
				}
			}
			if (world instanceof Level _level)
				_level.getGameRules().getRule(MinecraftEarthModModGameRules.EXPERIMENTALMODE).set((false), _level.getServer());
			MinecraftEarthModModVariables.MapVariables
					.get(world).ExperimentalMode = !MinecraftEarthModModVariables.MapVariables.get(world).ExperimentalMode;
			MinecraftEarthModModVariables.MapVariables.get(world).syncData(world);
			if (!world.isClientSide()) {
				MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
				if (_mcserv != null)
					_mcserv.getPlayerList().broadcastSystemMessage(Component
							.literal(("Experimental Mode Set To: " + MinecraftEarthModModVariables.MapVariables.get(world).ExperimentalMode)), false);
			}
		} else {
			if (world instanceof Level _level)
				_level.getGameRules().getRule(MinecraftEarthModModGameRules.EXPERIMENTALMODE).set((true), _level.getServer());
			MinecraftEarthModModVariables.MapVariables
					.get(world).ExperimentalMode = !MinecraftEarthModModVariables.MapVariables.get(world).ExperimentalMode;
			MinecraftEarthModModVariables.MapVariables.get(world).syncData(world);
			if (!world.isClientSide()) {
				MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
				if (_mcserv != null)
					_mcserv.getPlayerList().broadcastSystemMessage(Component
							.literal(("Experimental Mode Set To: " + MinecraftEarthModModVariables.MapVariables.get(world).ExperimentalMode)), false);
			}
		}
	}
}
