
package net.minecraftearthmod.entity;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.material.Material;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvent;

import javax.annotation.Nullable;





public class TropicalSlimeBigEntity extends Monster  {


	public TropicalSlimeBigEntity(PlayMessages.SpawnEntity packet, Level world) {
    	this(MinecraftEarthModModEntities.TROPICAL_SLIME_BIG.get(), world);
    }

	public TropicalSlimeBigEntity(EntityType<TropicalSlimeBigEntity> type, Level world) {
    	super(type, world);
		maxUpStep = 0.6f;
		xpReward = 5;
		setNoAi(false);

        	setCustomName(Component.literal("Work in Progress!"));
        	setCustomNameVisible(true);



	}

	@Override public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}


	@Override protected void registerGoals() {
		super.registerGoals();

            this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Player.class, false,
        false));this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, ServerPlayer.class, false,
        false));this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, FurnaceGolemEntity.class, false,
        false));this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));this.goalSelector.addGoal(5, new FloatGoal(this));this.goalSelector.addGoal(6, new LeapAtTargetGoal(this, (float)0.5));this.goalSelector.addGoal(7, new MeleeAttackGoal(this, 1.2, false) {

	@Override protected double getAttackReachSqr(LivingEntity entity) {
		return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
    }


});this.targetSelector.addGoal(8, new HurtByTargetGoal(this)
.setAlertOthers());

	}

	@Override public MobType getMobType() {
		return MobType.UNDEFINED;
	}





	@Override public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.slime.squish"));
	}


	@Override public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.slime.hurt"));
	}

	@Override public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.slime.death"));
	}



	@Override public boolean hurt(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
		return super.hurt(source, amount);
	}

















	public static void init() {

	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0);
		builder = builder.add(Attributes.MAX_HEALTH, 16);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 5);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);






		return builder;
	}

}
