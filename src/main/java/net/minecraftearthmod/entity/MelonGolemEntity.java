
package net.minecraftearthmod.entity;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.material.Material;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvent;

import javax.annotation.Nullable;





public class MelonGolemEntity extends PathfinderMob implements RangedAttackMob {


	public MelonGolemEntity(PlayMessages.SpawnEntity packet, Level world) {
    	this(MinecraftEarthModModEntities.MELON_GOLEM.get(), world);
    }

	public MelonGolemEntity(EntityType<MelonGolemEntity> type, Level world) {
    	super(type, world);
		maxUpStep = 0.6f;
		xpReward = 3;
		setNoAi(false);



        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(MinecraftEarthModModBlocks.CARVED_MELON.get()));

	}

	@Override public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}


	@Override protected void registerGoals() {
		super.registerGoals();

            this.targetSelector.addGoal(1, new NearestAttackableTargetGoal(this, Monster.class, false,
        false));this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1));this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));this.goalSelector.addGoal(4, new FloatGoal(this));

            this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 20, 10f) {
				@Override public boolean canContinueToUse() {
					return this.canUse();
				}
			});
	}

	@Override public MobType getMobType() {
		return MobType.UNDEFINED;
	}





	@Override public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.snow_golem.ambient"));
	}

	@Override public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.snow.step")), 0.15f, 1);
	}

	@Override public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.snow_golem.hurt"));
	}

	@Override public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.break"));
	}











	    @Override public void performRangedAttack(LivingEntity target, float flval) {
				MelonGolemProjectileEntity.shoot(this, target);
		}









	public static void init() {
			SpawnPlacements.register(MinecraftEarthModModEntities.MELON_GOLEM.get(),
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
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 4);
		builder = builder.add(Attributes.ARMOR, 0.1);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 20);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);






		return builder;
	}

}
