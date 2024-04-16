package net.minecraftearthmod.procedures;

import net.minecraftearthmod.network.MinecraftEarthModModVariables;
import net.minecraftearthmod.init.MinecraftEarthModModGameRules;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

public class ToggleExperimentalModeProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (MinecraftEarthModModVariables.MapVariables.get(world).ExperimentalMode) {
			if (!(entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel
					&& _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft_earth_mod:experimenter"))).isDone())) {
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft_earth_mod:experimenter"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
			world.getLevelData().getGameRules().getRule(MinecraftEarthModModGameRules.EXPERIMENTALMODE).set(false, world.getServer());
			MinecraftEarthModModVariables.MapVariables.get(world).ExperimentalMode = !MinecraftEarthModModVariables.MapVariables.get(world).ExperimentalMode;
			MinecraftEarthModModVariables.MapVariables.get(world).syncData(world);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Experimental Mode Set To: " + MinecraftEarthModModVariables.MapVariables.get(world).ExperimentalMode)), false);
		} else {
			world.getLevelData().getGameRules().getRule(MinecraftEarthModModGameRules.EXPERIMENTALMODE).set(true, world.getServer());
			MinecraftEarthModModVariables.MapVariables.get(world).ExperimentalMode = !MinecraftEarthModModVariables.MapVariables.get(world).ExperimentalMode;
			MinecraftEarthModModVariables.MapVariables.get(world).syncData(world);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("Experimental Mode Set To: " + MinecraftEarthModModVariables.MapVariables.get(world).ExperimentalMode)), false);
		}
	}
}
