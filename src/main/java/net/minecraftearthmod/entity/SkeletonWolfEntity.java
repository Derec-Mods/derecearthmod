
package net.minecraftearthmod.entity;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.material.Material;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvent;

import javax.annotation.Nullable;





public class SkeletonWolfEntity extends TamableAnimal  {


	public SkeletonWolfEntity(PlayMessages.SpawnEntity packet, Level world) {
    	this(MinecraftEarthModModEntities.SKELETON_WOLF.get(), world);
    }

	public SkeletonWolfEntity(EntityType<SkeletonWolfEntity> type, Level world) {
    	super(type, world);
		maxUpStep = 0.6f;
		xpReward = 5;
		setNoAi(false);




	}

	@Override public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}


	@Override protected void registerGoals() {
		super.registerGoals();

            this.goalSelector.addGoal(1, new FollowOwnerGoal(this, 1, (float) 10, (float) 2, false)			{
                @Override public boolean canUse() {
                	double x = SkeletonWolfEntity.this.getX();
			        double y = SkeletonWolfEntity.this.getY();
			        double z = SkeletonWolfEntity.this.getZ();
			        Entity entity = SkeletonWolfEntity.this;
					Level world = SkeletonWolfEntity.this.level;
                	return super.canUse() &&         

    CheckWolfSitProcedure.execute(entity)

;
                }
                @Override public boolean canContinueToUse() {
                	double x = SkeletonWolfEntity.this.getX();
			        double y = SkeletonWolfEntity.this.getY();
			        double z = SkeletonWolfEntity.this.getZ();
			        Entity entity = SkeletonWolfEntity.this;
			        Level world = SkeletonWolfEntity.this.level;
                	return super.canContinueToUse() &&         

    CheckWolfSitProcedure.execute(entity)

;
                }
			}
);
this.goalSelector.addGoal(2, new OwnerHurtByTargetGoal(this));
this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, MuddyPigEntity.class, false,
        false)			{
                @Override public boolean canUse() {
                	double x = SkeletonWolfEntity.this.getX();
			        double y = SkeletonWolfEntity.this.getY();
			        double z = SkeletonWolfEntity.this.getZ();
			        Entity entity = SkeletonWolfEntity.this;
					Level world = SkeletonWolfEntity.this.level;
                	return super.canUse() &&         

    WolfTameProcedure.execute(entity)

;
                }
                @Override public boolean canContinueToUse() {
                	double x = SkeletonWolfEntity.this.getX();
			        double y = SkeletonWolfEntity.this.getY();
			        double z = SkeletonWolfEntity.this.getZ();
			        Entity entity = SkeletonWolfEntity.this;
			        Level world = SkeletonWolfEntity.this.level;
                	return super.canContinueToUse() &&         

    WolfTameProcedure.execute(entity)

;
                }
			}
);this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, ServerPlayer.class, false,
        false)			{
                @Override public boolean canUse() {
                	double x = SkeletonWolfEntity.this.getX();
			        double y = SkeletonWolfEntity.this.getY();
			        double z = SkeletonWolfEntity.this.getZ();
			        Entity entity = SkeletonWolfEntity.this;
					Level world = SkeletonWolfEntity.this.level;
                	return super.canUse() &&         

    WolfTameProcedure.execute(entity)

;
                }
                @Override public boolean canContinueToUse() {
                	double x = SkeletonWolfEntity.this.getX();
			        double y = SkeletonWolfEntity.this.getY();
			        double z = SkeletonWolfEntity.this.getZ();
			        Entity entity = SkeletonWolfEntity.this;
			        Level world = SkeletonWolfEntity.this.level;
                	return super.canContinueToUse() &&         

    WolfTameProcedure.execute(entity)

;
                }
			}
);this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.2, false) {

	@Override protected double getAttackReachSqr(LivingEntity entity) {
		return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
    }


});this.goalSelector.addGoal(6, new FollowMobGoal(this, (float)1, 10, 5));
this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1));this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

	}

	@Override public MobType getMobType() {
		return MobType.UNDEAD;
	}





	@Override public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.skeleton.ambient"));
	}

	@Override public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.skeleton.step")), 0.15f, 1);
	}

	@Override public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.skeleton.hurt"));
	}

	@Override public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wolf.death"));
	}



	@Override public boolean hurt(DamageSource source, float amount) {
    HowlProcedure.execute(
    this.level,this.getX(),this.getY(),this.getZ(),this
);
		return super.hurt(source, amount);
	}

	@Override public void die(DamageSource source) {
		super.die(source);
    HowlProcedure.execute(
    this.level,this.getX(),this.getY(),this.getZ(),this
);
	}

	@Override public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty,
			MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
    WolfySpawnProcedure.execute(
    this
);
		return retval;
	}


	@Override public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level.isClientSide());


			Item item = itemstack.getItem();
			if (itemstack.getItem() instanceof SpawnEggItem) {
				retval = super.mobInteract(sourceentity, hand);
			} else if (this.level.isClientSide()) {
				retval = (this.isTame() && this.isOwnedBy(sourceentity) || this.isFood(itemstack))
						? InteractionResult.sidedSuccess(this.level.isClientSide()) : InteractionResult.PASS;
			} else {
				if (this.isTame()) {
					if (this.isOwnedBy(sourceentity)) {
						if (item.isEdible() && this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
							this.usePlayerItem(sourceentity, hand, itemstack);
							this.heal((float)item.getFoodProperties().getNutrition());
							retval = InteractionResult.sidedSuccess(this.level.isClientSide());
						} else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
							this.usePlayerItem(sourceentity, hand, itemstack);
							this.heal(4);
							retval = InteractionResult.sidedSuccess(this.level.isClientSide());
						} else {
							retval = super.mobInteract(sourceentity, hand);
						}
					}
				} else if (this.isFood(itemstack)) {
					this.usePlayerItem(sourceentity, hand, itemstack);
					if (this.random.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, sourceentity)) {
						this.tame(sourceentity);
						this.level.broadcastEntityEvent(this, (byte) 7);
					} else {
						this.level.broadcastEntityEvent(this, (byte) 6);
					}

					this.setPersistenceRequired();
					retval = InteractionResult.sidedSuccess(this.level.isClientSide());
				} else {
					retval = super.mobInteract(sourceentity, hand);
					if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
						this.setPersistenceRequired();
				}
			}


			double x = this.getX();
			double y = this.getY();
			double z = this.getZ();
			Entity entity = this;
			Level world = this.level;
    

    SitDownWolfProcedure.execute(world,x,y,z,entity)
;
				return retval;
	}

	@Override public void awardKillScore(Entity entity, int score, DamageSource damageSource) {
		super.awardKillScore(entity, score, damageSource);
    HowlProcedure.execute(
    this.level,this.getX(),this.getY(),this.getZ(),entity
);
	}

	@Override public void baseTick() {
		super.baseTick();
    CheckTameProcedure.execute(
    this.level,this.getX(),this.getY(),this.getZ(),this
);
	}



        @Override public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
			SkeletonWolfEntity retval = MinecraftEarthModModEntities.SKELETON_WOLF.get().create(serverWorld);
			retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
			return retval;
		}

		@Override public boolean isFood(ItemStack stack) {
			return List.of(Items.ROTTEN_FLESH).contains(stack.getItem());
		}








	public static void init() {
			SpawnPlacements.register(MinecraftEarthModModEntities.SKELETON_WOLF.get(),
					SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
					(entityType, world, reason, pos, random) -> {
						int x = pos.getX();
						int y = pos.getY();
						int z = pos.getZ();
						return         

    CheckHostileMobSpawnsProcedure.execute(world)

;
					}
			);

			DungeonHooks.addDungeonMob(MinecraftEarthModModEntities.SKELETON_WOLF.get(), 180);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 4);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);






		return builder;
	}

}
