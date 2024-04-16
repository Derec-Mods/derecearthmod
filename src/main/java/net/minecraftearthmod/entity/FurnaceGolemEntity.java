
package net.minecraftearthmod.entity;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.material.Material;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvent;

import javax.annotation.Nullable;





public class FurnaceGolemEntity extends IronGolem  {


	public FurnaceGolemEntity(PlayMessages.SpawnEntity packet, Level world) {
    	this(MinecraftEarthModModEntities.FURNACE_GOLEM.get(), world);
    }

	public FurnaceGolemEntity(EntityType<FurnaceGolemEntity> type, Level world) {
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

            this.targetSelector.addGoal(1, new HurtByTargetGoal(this)
.setAlertOthers());this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, true) {

	@Override protected double getAttackReachSqr(LivingEntity entity) {
		return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
    }


});this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.9));this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));this.goalSelector.addGoal(5, new FloatGoal(this));

	}

	@Override public MobType getMobType() {
		return MobType.UNDEFINED;
	}






	@Override public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.step")), 0.15f, 1);
	}

	@Override public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.hurt"));
	}

	@Override public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.death"));
	}



	@Override public boolean hurt(DamageSource source, float amount) {
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.DROWN)
				return false;
		return super.hurt(source, amount);
	}


	@Override public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty,
			MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
    SetPissedProcedure.execute(
    this
);
		return retval;
	}




	@Override public void baseTick() {
		super.baseTick();
    FurnaceGolemOnEntityTickUpdateProcedure.execute(
    this.level,this.getX(),this.getY(),this.getZ(),this
);
	}











	public static void init() {
			SpawnPlacements.register(MinecraftEarthModModEntities.FURNACE_GOLEM.get(),
					SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					(entityType, world, reason, pos, random) -> {
						int x = pos.getX();
						int y = pos.getY();
						int z = pos.getZ();
						return         

    GetSpawnGolemsProcedure.execute(world)

;
					}
			);

	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2);
		builder = builder.add(Attributes.MAX_HEALTH, 100);
		builder = builder.add(Attributes.ARMOR, 3);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 10);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);

		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 10);

		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.5);




		return builder;
	}

}
