package net.minecraftearthmod.procedures;

import net.minecraftearthmod.MinecraftEarthModModElements;
import net.minecraftearthmod.MinecraftEarthModMod;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@MinecraftEarthModModElements.ModElement.Tag
public class CheckTameProcedure extends MinecraftEarthModModElements.ModElement {
	public CheckTameProcedure(MinecraftEarthModModElements instance) {
		super(instance, 121);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftEarthModMod.LOGGER.warn("Failed to load dependency entity for procedure CheckTame!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof TameableEntity) ? ((TameableEntity) entity).isTamed() : false)) {
			entity.getPersistentData().putString("isTame", "yes");
		}
		if ((((entity.getPersistentData().getString("sit"))).equals("sitting"))) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 696, (int) 100, (false), (false)));
		} else {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(Effects.SLOWNESS);
			}
		}
	}
}
