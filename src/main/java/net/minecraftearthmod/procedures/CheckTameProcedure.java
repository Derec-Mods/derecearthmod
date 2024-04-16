package net.minecraftearthmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class CheckTameProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)) {
			if (world instanceof Level _lvl && _lvl.isDay() && !world.getLevelData().isRaining() && !world.getLevelData().isThundering()) {
				if (world.canSeeSkyFromBelowWater(new BlockPos(x, y, z))) {
					entity.setSecondsOnFire(10);
				}
			}
		}
		if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
			entity.getPersistentData().putString("isTame", "yes");
		}
		if ((entity.getPersistentData().getString("sit")).equals("sitting")) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 696, 100, (false), (false)));
			if (Math.random() <= 0.01 && (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false)) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, x, y, z, 2, 1, 1, 1, 0);
			}
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
		}
	}
}
