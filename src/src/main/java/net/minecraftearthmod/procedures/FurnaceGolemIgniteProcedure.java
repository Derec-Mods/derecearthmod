package net.minecraftearthmod.procedures;

import net.minecraftearthmod.MinecraftEarthModModElements;

import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@MinecraftEarthModModElements.ModElement.Tag
public class FurnaceGolemIgniteProcedure extends MinecraftEarthModModElements.ModElement {
	public FurnaceGolemIgniteProcedure(MinecraftEarthModModElements instance) {
		super(instance, 39);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FurnaceGolemIgnite!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof MonsterEntity)) {
			entity.setFire((int) 2);
		}
	}
}
