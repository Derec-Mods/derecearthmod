
package net.minecraftearthmod.entity;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.material.Material;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvent;

import javax.annotation.Nullable;





public class VillerWitchEntity extends Monster implements RangedAttackMob {


	public VillerWitchEntity(PlayMessages.SpawnEntity packet, Level world) {
    	this(MinecraftEarthModModEntities.VILLER_WITCH.get(), world);
    }

	public VillerWitchEntity(EntityType<VillerWitchEntity> type, Level world) {
    	super(type, world);
		maxUpStep = 0.6f;
		xpReward = 10;
		setNoAi(false);




	}

	@Override public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}


	@Override protected void registerGoals() {
		super.registerGoals();

            this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, false,
        false));this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, ServerPlayer.class, false,
        false));this.targetSelector.addGoal(3, new HurtByTargetGoal(this)
);this.goalSelector.addGoal(4, new RandomStrollGoal(this, 1));this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));this.goalSelector.addGoal(6, new FloatGoal(this));

            this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 20, 10f) {
				@Override public boolean canContinueToUse() {
					return this.canUse();
				}
			});
	}

	@Override public MobType getMobType() {
		return MobType.ILLAGER;
	}





	@Override public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.ambient"));
	}


	@Override public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.hurt"));
	}

	@Override public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.witch.death"));
	}



	@Override public boolean hurt(DamageSource source, float amount) {
    PassiveHealProcedure.execute(
    this.level,this.getX(),this.getY(),this.getZ(),this
);
			if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
				return false;
		return super.hurt(source, amount);
	}








	    @Override public void performRangedAttack(LivingEntity target, float flval) {
				VillerWitchPotionEntity.shoot(this, target);
		}









	public static void init() {
			SpawnPlacements.register(MinecraftEarthModModEntities.VILLER_WITCH.get(),
					SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
						(entityType, world, reason, pos, random) ->
								(world.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(world, pos, random)
										&& Mob.checkMobSpawnRules(entityType, world, reason, pos, random))
			);

	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 30);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);






		return builder;
	}

}
